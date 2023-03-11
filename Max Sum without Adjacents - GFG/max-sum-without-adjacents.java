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
        int[] dp=new int[n+1];

         
        dp[0]=arr[0];
        int sum=0;
        for(int i=1;i<n;i++){
            int pick= arr[i]; if(i>1){pick += dp[i-2];
                
            }
            int notpick =0+dp[i-1];
            
            dp[i]=Math.max(pick,notpick);
        }
        return dp[n-1];
    }
}