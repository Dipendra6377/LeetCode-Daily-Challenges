class Solution {
    List<List<Integer>> adj = new ArrayList<>();
    public long countPairs(int n, int[][] edges) {
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        long res=0;long sum=n;
        
        boolean[] vis =new boolean[n];
        for(int i=0;i<n;i++){
            if(vis[i]==false){
                int curr =dfs(vis,i,new int[1]);
                sum=sum-curr;
                res+=sum*curr;
            }
        }
        return res;
    }
    int dfs(boolean[] vis,int node,int[] count){
        if(vis[node]==true) return count[0];
        vis[node]=true;
        count[0]++;
        for(int x:adj.get(node)){
            dfs(vis,x,count);
        }
        return count[0];
    }
}