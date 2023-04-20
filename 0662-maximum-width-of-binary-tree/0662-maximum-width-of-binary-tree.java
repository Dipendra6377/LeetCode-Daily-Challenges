/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 class Pair{
     TreeNode node;
     int ind;
     Pair(TreeNode _node,int _ind){
         node=_node;
         ind=_ind;
     }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;

        int ans=0;
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,0));

        while(!q.isEmpty()){
        
            int size=q.size();
            int min = q.peek().ind;
            int f=0,l=0;
            for(int i=0;i<size;i++)
            {
                int curInd = q.peek().ind-min;
                TreeNode node=q.peek().node;
                q.poll();

                if(i==0) f=curInd;
                if(i==size-1) l=curInd;

                if(node.left!=null) q.offer(new Pair(node.left,2*curInd+1));
                if(node.right!=null) q.offer(new Pair(node.right,2*curInd+2));


            }
            ans =Math.max(ans,l-f+1);
        }
        return ans;
    }
}