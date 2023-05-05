//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        int count=0;
        ArrayList<ArrayList<Integer>> newadj = new ArrayList<ArrayList<Integer>>();
        boolean[] vis = new boolean[V];
        
        for(int i=0;i<V;i++){
            newadj.add(new ArrayList<Integer>());
            
        }
        
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(adj.get(i).get(j)==1 && i!=j){
                    newadj.get(i).add(j);
                    newadj.get(j).add(i);
                }
            }
        }

        for(int i=0;i<V;i++){
            if(vis[i]==false){
                count++;
                helper(newadj,vis,i);
            }
        }
        return count;
    }
    
    static void helper(ArrayList<ArrayList<Integer>> newadj,boolean[] vis,int node){
        vis[node]=true;
        
        for(int i: newadj.get(node)){
            if(vis[i]==false){
                helper(newadj,vis,i);
            }
        }
    }
};