class Solution {
    public int longestCycle(int[] edges) {
        int[] count =new int[edges.length];
        int result=-1;
        for(int i=0;i<edges.length;i++){
            result =Math.max(result,dfs(i,1,edges,count));
        }
        return result;
    }

    public int dfs(int node,int total,int[] edges,int[] count){
        if(node==-1 || count[node]==-1) return -1;

        if(count[node]!=0) return total -count[node];

        count[node]=total;
        int result =dfs(edges[node],total+1,edges,count);
        count[node]=-1;

        return result;
    }
}