//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int M=sc.nextInt();
            
            int [][]grid=new int[N][M];
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    grid[i][j]=sc.nextInt();
                    
                }
            }
            
            Solution obj=new Solution();
            long res=obj.solve(N, M, grid);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int solve(int n, int m, int grid[][]){
        // Code here
        int[][][] dp =new int[n][m][m];
        for (int row1[][]: dp) {
            for (int row2[]: row1) {
                Arrays.fill(row2, -1);
            }
        }
        return helper(0,0,m-1,n,m,dp,grid);
    }
    
    public int helper(int i,int j1,int j2,int n,int m,int[][][] dp,int[][] grid){
        if(j1<0 || j2<0 || j1>=m || j2>=m ){
            return (int)(Math.pow(-10,9));
        }
        
        if(i==n-1){
            if(j1==j2) return grid[i][j1];
            else{
                return grid[i][j1]+grid[i][j2];
            }
        }
        if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];
        
        int max = Integer.MIN_VALUE;
        for(int d1=-1;d1<=1;d1++){
            int ans=0;
            for(int d2=-1;d2<=1;d2++){
                if(j1==j2) ans= grid[i][j1] + helper(i+1,j1+d1,j2+d2,n,m,dp,grid);
                else ans =grid[i][j1]+grid[i][j2]+helper(i+1,j1+d1,j2+d2,n,m,dp,grid);
                max = Math.max(ans,max);
            }
        }
        return dp[i][j1][j2] =max;
    }
}