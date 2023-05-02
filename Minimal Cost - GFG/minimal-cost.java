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
            int K=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
            }
            Solution obj=new Solution();
            int res=obj.minimizeCost(arr,N,K);
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int minimizeCost(int arr[],int n,int k){
        //code here
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return helper(arr,n-1,dp,k);
    }
    
    public int helper(int[] arr,int n,int[] dp,int k){
        if(n==0) return 0;
        if(dp[n]!=-1) return dp[n];
        int steps  =Integer.MAX_VALUE;
        
        for(int j=1;j<=k;j++){
            if(n-j>=0){
                int jump=helper(arr,n-j,dp,k)+Math.abs(arr[n]-arr[n-j]);
                steps=Math.min(steps,jump);
            }
            
        }
        return dp[n]=steps;
    }
}
