//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int K = Integer.parseInt(in.readLine());
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int A[] = new int[N];
            for (int i = 0; i < N; i++) A[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            System.out.println(ob.maxProfit(K, N, A));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int maxProfit(int k, int n, int a[]) {
        // code here
        int[][] dp=new int[n][2*k];
        
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        
        return f(a,0,0,dp,k);
    }
    static int f(int[] a,int ind,int trans,int[][] dp,int k){
        int n=a.length;
        if(ind==n || trans==2*k) return 0;
        
        if(dp[ind][trans]!=-1) return dp[ind][trans];
        
        int profit=0;
        if(trans%2==0){
            profit = Math.max(-a[ind] +f(a,ind+1,trans+1,dp,k),
                f(a,ind+1,trans,dp,k));
        }
        else{
            profit = Math.max(a[ind] +f(a,ind+1,trans+1,dp,k),
                f(a,ind+1,trans,dp,k));
        }
        return dp[ind][trans]=profit;
    }
}