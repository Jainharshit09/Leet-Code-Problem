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

 //using morris inorder traversal we can do
 // go left right and connect to curr
 // than make sure remove that curr.left but before that connect with right to curr
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode curr=root;
        List<Integer>ans=new ArrayList<>();
        while(curr!=null){
            if(curr.left==null){
                ans.add(curr.val);
                curr=curr.right;
            }
            else{
                TreeNode leftchild=curr.left;
                while(leftchild.right!=null){
                    leftchild=leftchild.right;
                }
                leftchild.right=curr;
                TreeNode temp=curr;
                curr=curr.left;
                temp.left=null;
            }
        }
        return ans;
    }
}