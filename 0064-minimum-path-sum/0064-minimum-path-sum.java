class Solution {
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int[][] dp=new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0) dp[i][j]=grid[i][j];

                else{
                    int up=grid[i][j];
                    if(i>0) up+=dp[i-1][j];
                    else up=(int)1e9;

                    int down=grid[i][j];
                    if(j>0) down+=dp[i][j-1];
                    else down=(int)1e9;

                    dp[i][j]=Math.min(up,down);
                }
            }
        }
        return dp[n-1][m-1];
    }
}