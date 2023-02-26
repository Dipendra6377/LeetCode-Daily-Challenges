//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends

class pair{
    int first;
    int second;
    
    pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[V];
        Arrays.fill(vis,false);
        
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(findcycle(i,adj,vis)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean findcycle(int src ,ArrayList<ArrayList<Integer>> adj,boolean[] vis ){
        vis[src]=true;
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(src,-1));
        
        while(!q.isEmpty()){
            int node = q.peek().first;
            int parent = q.peek().second;
            
            q.remove();
            
            for(Integer child : adj.get(node)){
                if(vis[child]!=true){
                    vis[child]=true;
                    q.add(new pair(child,node));
                }
                else if(parent!=child){
                    return true;
                }
            }
        }
        return false;
    }
}