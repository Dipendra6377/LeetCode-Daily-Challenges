class Solution {
    public int maxDistance(int[][] grid) {
        Queue<int[]> q=new LinkedList<>();
        int n=grid.length;
        int m= grid[0].length;
        int[][] direction={{-1, 0}, {1,0}, {0, 1}, {0, -1}};

        for(int i=0;i< grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    q.add(new int[]{i,j});
                }
            }
        }
        if(q.isEmpty() || q.size()==n*m) return -1;
        int ans=0;
        while(!q.isEmpty()){
            int size=q.size();
            ans++;

            for(int i=0;i<size;i++){
                int[] land = q.remove();
                int row=land[0];
                int col=land[1];

                for(int[] dir : direction){
                    int x=row +dir[0];
                    int y=col+dir[1];

                    if(x>=0 && x<m && y<n && y>=0 && grid[x][y]==0){
                        grid[x][y]=1;
                        q.offer(new int[]{x,y});
                    }
                }
            }
        }
        return ans-1;
    }
}