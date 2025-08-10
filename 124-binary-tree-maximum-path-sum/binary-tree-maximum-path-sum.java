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

 // we can have root value as a good answer 
 // or khud hi ans ho ga
 //not good of left and right  it will send him root

 // temp=max(Math.max(left,right)+root.val,root.val);
 //ans=Math.max(temp,left+right);
 //res=Math.max(ans,res);
class Solution {
    int res;
    public int solve(TreeNode root){
        //base case
        if(root==null)return 0;

        //intution
        int left=solve(root.left);
        int right=solve(root.right);

        //update
        int temp=Math.max(Math.max(left,right)+root.val,root.val);
        int ans=Math.max(temp,left+right+root.val);
        res=Math.max(res,ans);
        return temp;
    }
    public int maxPathSum(TreeNode root) {
        res=Integer.MIN_VALUE;
        solve(root);
        return res;
    }
}