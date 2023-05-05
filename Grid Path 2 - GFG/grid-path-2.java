//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] grid = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            Solution obj = new Solution();
            int res = obj.totalWays(N, M, grid);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int totalWays(int n, int m, int grid[][]) {
        // Code here
        int[][] dp=new int[n][m];
        
        for(int[] i:dp)
            Arrays.fill(i,-1);
        
        return helper(grid,dp,n-1,m-1);
    }
    
    public int helper(int[][] grid,int[][] dp,int i,int j){
        int mod =1000000007;
        if(i<0 || j<0 || grid[i][j]==1) return 0;
        if(i==0 && j==0) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        
        int left = helper(grid,dp,i-1,j);
        int right = helper(grid,dp,i,j-1);
        
        return dp[i][j]=(left+right)%mod;
        
        
    }
}