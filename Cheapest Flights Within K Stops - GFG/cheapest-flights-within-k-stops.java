//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int edge=sc.nextInt();
            int[][] adj = new int[edge][3];
            for(int i=0;i<edge;i++){
                adj[i][0]=sc.nextInt();
                adj[i][1]=sc.nextInt();
                adj[i][2]=sc.nextInt();
            }
            int src=sc.nextInt();
            int dst=sc.nextInt();
            int k=sc.nextInt();
            Solution obj = new Solution();
            int res = obj.CheapestFLight(n,adj,src,dst,k);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends

class tuple{
    int stop;
    int node;
    int dist;
    tuple(int stop,int node,int dist){
        this.stop=stop;
        this.node=node;
        this.dist=dist;
    }
}

class pair{
    int first;
    int second;
    pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    
    public int CheapestFLight(int n,int flight[][],int src,int dst,int k) {
        // Code here
        
        ArrayList<ArrayList<pair>> adj =new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<pair>());
        }
        int m=flight.length;
        
        for(int i=0;i<m;i++){
            adj.get(flight[i][0]).add(new pair(flight[i][1],flight[i][2]));
        }
        // no need of priority queue it take logn more space as stop are can also go in order on queue
        Queue<tuple> q=new LinkedList<>();
        q.add(new tuple(0,src,0));
        int[] dist=new int[n];
        
        for(int i=0;i<n;i++){
            dist[i]=(int)1e9;
        }
        dist[src]=0;
        
        while(!q.isEmpty()){
            tuple temp = q.peek();
            q.remove();
            int stops = temp.stop;
            int nodes =temp.node;
            int d =temp.dist;
            
            if(stops> k) continue;
            
            for(pair iter :adj.get(nodes)){
                int adjnode =iter.first;
                int cost =iter.second;
                
                if(d+cost<dist[adjnode] && stops<=k){
                    dist[adjnode]=d+cost;
                    q.add(new tuple(1+stops,adjnode,cost+d));
                }
            }
        }
        
        if(dist[dst]==(int)1e9) return -1;
        return dist[dst];
        
    }
}