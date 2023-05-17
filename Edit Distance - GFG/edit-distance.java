//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public int editDistance(String s, String t) {
        int n=s.length();
        int m=t.length();
        int[][] dp=new int[n][m];
        
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        
        return f(n-1,m-1,s,t,dp);
    }
    public int f(int i,int j,String s,String t,int[][] dp){
        if(i<0) return j+1;
        if(j<0) return i+1;
        
        if(dp[i][j]!=-1) return dp[i][j];
        
        if(s.charAt(i)==t.charAt(j)) {
            return dp[i][j] =f(i-1,j-1,s,t,dp);
        }
        else{
            return dp[i][j]=1+Math.min(f(i-1,j,s,t,dp),
            Math.min(f(i,j-1,s,t,dp),f(i-1,j-1,s,t,dp)));
        }
    }
}