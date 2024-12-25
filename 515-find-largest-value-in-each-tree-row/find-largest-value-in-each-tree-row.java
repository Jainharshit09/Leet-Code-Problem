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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if (root == null) {
            return ans;  // Return an empty list if the root is null
        }
        Queue<TreeNode>pq=new LinkedList<>();
        pq.add(root);
        while(!pq.isEmpty()){
            int n=pq.size();
            int max=Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                TreeNode curr=pq.poll();
                max=Math.max(curr.val,max);
                if(curr.left!=null){
                    pq.add(curr.left);
                }
                if(curr.right!=null){
                    pq.add(curr.right);
                }
            }
            ans.add(max);
        }
        return ans;
    }
}