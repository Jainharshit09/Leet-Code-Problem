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
    int result;
    public int diameter(TreeNode root){
        //base condition
        if(root==null)return 0 ;
        //intement
        int left=diameter(root.left);
        int right=diameter(root.right);
        //update work
        int temp=Math.max(left,right)+1;
        int ans=Math.max(left+right+1,temp);
        result=Math.max(ans,result);
        //we need return temp because of recursion
        return temp;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        result=Integer.MIN_VALUE;
        diameter(root);
        return result-1;
    }
}