//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public static boolean isPages(int[] arr,int pages,int m){
        int count=0;
        int sumPages=0;
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]+sumPages>pages){
                count++;
                sumPages=arr[i];
                if(sumPages>pages) return false;
            }
            else sumPages+=arr[i];
            
        }
        return count<m;
    }
    public static int findPages(int[] arr,int n,int m)
    {
        //Your code here
        if(m>n) return -1;
        int sum=0;
        int min =Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            min=Math.min(min,arr[i]);
        }
        
        int i=min;
        int j=sum;
        
        while(i<=j){
            int mid =(i+j)/2;
            
            if(isPages(arr,mid,m)){
                j=mid-1;
            }
            else{
                i=mid+1;
            }
        }
        return i;
    }
};