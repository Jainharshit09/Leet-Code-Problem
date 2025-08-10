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

//WE CAN SOLVE USING MORRIS TRAVERSAL
//in which check there is left go left right and connect to root.right with 
// and root.right will curr.left 
// and move root=root.right

class Solution {
    public void flatten(TreeNode root) {
        TreeNode curr=root;
        while(curr!=null){
            if(curr.left!=null){
                TreeNode leftPrev=curr.left;
                while(leftPrev.right!=null){
                    leftPrev=leftPrev.right;
                }
                leftPrev.right=curr.right;
                curr.right=curr.left;
                curr.left=null;
            }
            curr=curr.right;
        }
    }
}