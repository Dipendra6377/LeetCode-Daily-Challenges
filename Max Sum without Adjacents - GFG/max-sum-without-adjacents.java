//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int findMaxSum(int arr[], int n) {
        // code here
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        
        return helper(dp,arr,n-1);
    }
    
    int helper(int[] dp,int[] arr,int n){
        if(n<0) return 0;
        if(n==0){
            return arr[n];
        }
        
        if(dp[n]!=-1) return dp[n];
        int pick =arr[n]+helper(dp,arr,n-2);
        
        int notpick =helper(dp,arr,n-1);
        
        return dp[n] =Math.max(pick,notpick);
    }
}