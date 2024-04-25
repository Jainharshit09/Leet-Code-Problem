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
    public TreeNode min(TreeNode root ){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
    public TreeNode max(TreeNode root){
        while(root.right!=null){
            root=root.right;
        }
        return root;
    }
    public boolean isValidBST(TreeNode root) {
        if(root==null){return true;}
        if(root.left!=null){
            TreeNode left_tree_max=max(root.left);
            if (left_tree_max.val >= root.val) {
                return false;}
        }
        if(root.right!=null){
            TreeNode right_tree_min=min(root.right);
            if(right_tree_min.val<=root.val){return false;}
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }
}