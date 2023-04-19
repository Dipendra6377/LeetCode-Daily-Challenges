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
class Solution {
    int maxlength=0;
    
    public void func(TreeNode root,int dir ,int currlen){
        if(root==null) return;
        
        maxlength=Math.max(maxlength,currlen);
        
        func(root.left,0,dir==1?currlen+1:1);
        func(root.right,1,dir==1?1:currlen+1);
    }
    public int longestZigZag(TreeNode root) {
        func(root,0,0);    //left=0;
        func(root,1,0);    //right=1;
        
        return maxlength;
    }
}