//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Pair{
    int row=0;
    int col=0;
    int time=0;

    Pair(int row,int col,int time){
        this.row=row;
        this.col=col;
        this.time=time;
    }
}
class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        
       if(grid == null || grid.length == 0) return 0;
        Queue<Pair> q=new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;
        int vis[][] =new int[n][m];
        int cntfresh=0;

        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.offer(new Pair(i,j,0));
                    vis[i][j]=2;
                }
                else{
                    vis[i][j]=0;
                }
                if(grid[i][j]==1) cntfresh++;
            }
        }
        
        int cnt=0;
        int tm=0;
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        
        
        while(!q.isEmpty()){
            int first = q.peek().row;
            int second = q.peek().col;
            int t=q.peek().time;
            tm =Math.max(tm,t);
            q.remove();
            
            for(int i=0;i<4;i++){
                int nrow=first+dx[i];
                int ncol=second+dy[i];
                
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && vis[nrow][ncol]==0){
                    q.offer(new Pair(nrow,ncol,t+1));
                    vis[nrow][ncol]=2;
                    cnt++;
                }
            }
        }
        
        if(cnt!=cntfresh) return -1;
        return tm;
        
        
    }
}