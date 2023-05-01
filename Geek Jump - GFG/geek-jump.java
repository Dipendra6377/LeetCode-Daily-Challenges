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
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
                
            }
            Solution obj=new Solution();
            int res=obj.minimumEnergy(arr,N);
            System.out.println(res);
            
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    public int minimumEnergy(int arr[],int n){
        //code here
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        
        return helper(arr,n-1,dp);
    }
    
    public int helper(int[] arr,int n,int[] dp){
        if(n<=0) return 0;
        if(dp[n]!=-1) return dp[n];
        int right = Integer.MAX_VALUE;
        
        int left = helper(arr,n-1,dp) + Math.abs(arr[n]-arr[n-1]);
        
        if(n>1){
            right = helper(arr,n-2,dp)+Math.abs(arr[n]-arr[n-2]);
            
        }
        return dp[n] = Math.min(left,right);
    }
}