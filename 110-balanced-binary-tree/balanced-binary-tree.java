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
 //calculate the height of tree
 // than check abs(right-left)<=1 than we called it is bianry tree 
 // using sinple recusion
 //this will solve in O(N);
class Solution {
    public int height(TreeNode root){
        if(root==null)return 0;
        int left=height(root.left);
        if(left==-1)return -1;
        int right=height(root.right);
        if(right==-1)return -1;
        if(Math.abs(left-right)>1)return -1;
        return Math.max(left,right)+1;
    }
    public boolean isBalanced(TreeNode root) {
        return height(root)!=-1;
    }
}