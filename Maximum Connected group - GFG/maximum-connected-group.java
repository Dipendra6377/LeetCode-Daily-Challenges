//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    grid[i][j]=sc.nextInt();
                }
            }
            
            Solution obj = new Solution();
            int ans = obj.MaxConnection(grid);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findParent(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findParent(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionBysize(int u, int v) {
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if (ulp_u == ulp_v) return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}
class Solution {
    
    public int MaxConnection(int grid[][]) {
        //Your code here
        int n=grid.length;

        DisjointSet ds =new DisjointSet(n*n);

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0) continue;

                int[] dx ={-1,0,1,0};
                int[] dy ={0,-1,0,1};

                for(int ind=0;ind<4;ind++){
                    int row =i+dx[ind];
                    int col =j+dy[ind];

                    if(row>=0 && row<n && col>=0 && col<n && grid[row][col]==1){
                        int n1 = i*n+j;
                        int n2 =row*n+col;
                        ds.unionBysize(n1,n2);
                    }
                }
            }
        }

        int maxsize=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) continue;

                int[] dx ={-1,0,1,0};
                int[] dy ={0,-1,0,1};
                
                HashSet<Integer> set =new HashSet<>();
                for(int ind=0;ind<4;ind++){
                    int row =i+dx[ind];
                    int col =j+dy[ind];
                    if(row>=0 && row<n && col>=0 && col<n && grid[row][col]==1){
                        set.add(ds.findParent(row*n+col));
                    }
                }
                int size=0;
                for(Integer parent : set){
                    size+=ds.size.get(parent);
                }
                maxsize =Math.max(maxsize,size+1);
            }
        }
        for(int i=0;i<n*n;i++){
            maxsize=Math.max(maxsize,ds.size.get(ds.findParent(i))); 
        }
        return maxsize;
    }
    
}