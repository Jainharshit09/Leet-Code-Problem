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
    public void flatten(TreeNode root) {
        List<TreeNode>nodeList=new ArrayList<>();
        preorder(root,nodeList);
        for(int i=1;i<nodeList.size();i++){
            TreeNode prev=nodeList.get(i-1);
            TreeNode curr=nodeList.get(i);
            prev.left=null;
            prev.right=curr;
        }
    }
    public void preorder(TreeNode root,List<TreeNode>nodeList){
        if(root==null)return;
        nodeList.add(root);
        preorder(root.left,nodeList);
        preorder(root.right,nodeList);
    }
}