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
    int count=0;
    public void check(TreeNode root, PriorityQueue<Integer>pq){
        if(root==null)return ;
        if(!pq.isEmpty() && pq.peek()==root.val){
            count++;
        }
        if(root.left!=null){
            pq.add(root.left.val);
            check(root.left,pq);
            pq.remove(root.left.val);
        }
        if(root.right!=null){
            pq.add(root.right.val);
            check(root.right,pq);
            pq.remove(root.right.val);
        }
    }
    public int goodNodes(TreeNode root) {
        if(root==null)return 0;
       PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
       pq.add(root.val);
       check(root,pq);
       return count;
    }
}