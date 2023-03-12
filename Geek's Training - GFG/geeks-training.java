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
            int [][]points=new int[N][3];
            for(int i=0;i<N;i++){
                for(int j=0;j<3;j++){
                    points[i][j]=sc.nextInt();
                }
            }
            Solution obj=new Solution();
            int res=obj.maximumPoints(points,N);
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends


class Solution{
    public int maximumPoints(int points[][],int n){
        int[][] dp= new int[n][4];
        for (int[] row: dp)
            Arrays.fill(row, -1);
            
        return func(n-1,3,points,dp);
    }
    public int func(int day,int last,int[][] point,int[][] dp) {
        
        if(dp[day][last]!=-1) return dp[day][last];
        
        if(day==0){
            int maxi=0;
            for(int i=0;i<3;i++){
                if(i!=last){
                    maxi=Math.max(point[0][i],maxi);
                }
            }
            return dp[day][last] =maxi;
        }
        
        int maxi=0;
        
        for(int i=0;i<3;i++){
            if(i!=last){
                int points = point[day][i] +func(day-1,i,point,dp);
                maxi =Math.max(points,maxi);
            }
        }
        return dp[day][last] = maxi;
    }
}