//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.numberOfEnclaves(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int numberOfEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis =new int[n][m];
        
        for(int i=0;i<n;i++){
            if(grid[i][0]==1 && vis[i][0]==0){
                helper(grid,vis,i,0);
            }
            
            if(grid[i][m-1]==1 && vis[i][m-1]==0){
                helper(grid,vis,i,m-1);
            }
        }
        
        for(int j=0;j<m;j++){
            if(grid[0][j]==1 && vis[0][j]==0){
                helper(grid,vis,0,j);
            }
            
            if(grid[n-1][j]==1 && vis[n-1][j]==0){
                helper(grid,vis,n-1,j);
            }
        }
        int cnt=0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    cnt++;
                }
            }
        }
        return cnt;
        
    }
    void helper(int[][] grid,int[][] vis,int i,int j){
        int n=grid.length;
        int m=grid[0].length;
        vis[i][j]=1;
        
        int[] dx ={-1,0,1,0};
        int[] dy ={0,1,0,-1};
        
        
        for(int k=0;k<4;k++){
            int x=i+dx[k];
            int y=j+dy[k];
            
            if(x>=0 && x<n &&y>=0 && y<m && vis[x][y]==0 && grid[x][y]==1){
                helper(grid,vis,x,y);
            }
        }
    }
}