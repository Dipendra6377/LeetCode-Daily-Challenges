//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,int node, int[] vis,int[] dfsvis){
        vis[node]=1;
        dfsvis[node]=1;
        
        for(Integer child : adj.get(node)){
            if(vis[child]==0){
                if(dfs(adj,child,vis,dfsvis)==true){
                    return true;
                }
            }
            else if(dfsvis[child]==1){
                return true;
            }
        }
        dfsvis[node]=0;
        return false;
    }
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] vis=new int[V];
        int[] dfsvis=new int[V];
        
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                if(dfs(adj,i,vis,dfsvis)==true){
                    return true;
                }
            }
        }
        return false;
    }
}