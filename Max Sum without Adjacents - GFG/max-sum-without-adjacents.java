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
    int func(int[] arr,int[] dp,int ind){
        if(ind==0){
            return arr[0];
        }
        if(ind<0){
            return 0;
        }
        if(dp[ind]!=-1){
            return dp[ind];
        }
        
        int pick =arr[ind] + func(arr,dp,ind-2);
        
        int notpick = 0+ func(arr,dp,ind-1);
        
        return dp[ind] =Math.max(pick,notpick);
    }
    int findMaxSum(int arr[], int n) {
        // code here
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
         
        return func(arr,dp,n-1);
        
    }
}