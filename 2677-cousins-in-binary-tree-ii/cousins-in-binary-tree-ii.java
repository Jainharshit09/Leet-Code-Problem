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
    public TreeNode replaceValueInTree(TreeNode root) {
        if(root==null){
            return root;
        }
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        int level_sum=root.val;
        while(!q.isEmpty()){
            int n=q.size();
            int next_level_Sum=0;
            while(n-->0){
                TreeNode curr=q.poll();
                curr.val=level_sum-curr.val;
                int sibling_sum= (curr.left!=null?curr.left.val:0);
                sibling_sum+=(curr.right!=null?curr.right.val:0);
                if(curr.left!=null){
                    next_level_Sum+=curr.left.val;
                    curr.left.val=sibling_sum;
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    next_level_Sum+=curr.right.val;
                    curr.right.val=sibling_sum;
                    q.add(curr.right);
                }
            }
            level_sum=next_level_Sum;
        }
        return root;
    }
}