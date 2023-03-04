//{ Driver Code Starts
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
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class pair{
    int first;
    int second;
    
    pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        int n=arr.length;
        int[] dist =new int[100000];
        
        for(int i=0;i<100000;i++){
            dist[i]=(int)1e9;
        }
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(start,0));
        
        int mod=100000;
        
        while(!q.isEmpty()){
            pair temp =q.peek();
            int node=temp.first;
            int step=temp.second;
            
            q.remove();
            
            if(node==end){
                return dist[node];
            }
            
            for(int i=0;i<n;i++){
                int nodes =(node*arr[i])%mod;
                if(step+1<dist[nodes]){
                    dist[nodes]=1+step;
                    
                    q.add(new pair(nodes,1+step));
                }
                
            }
        }
        return -1;
        
    }
}
