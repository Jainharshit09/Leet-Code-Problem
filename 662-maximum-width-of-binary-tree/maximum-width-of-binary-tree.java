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

//easy using first 2*i+1 for left and 2*i+2 for right 
//now in that get the last leaf node right-left+1; remember peek and last element will give ans so go toward the deque
class tuple{
    TreeNode node;
    int idx;
    tuple(TreeNode node,int idx){
        this.node=node;
        this.idx=idx;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int max=0;
        Deque<tuple> q=new LinkedList<>();
        q.add(new tuple(root,0));
        while(!q.isEmpty()){
            int n=q.size();
            int l=q.peek().idx;
            int r=q.peekLast().idx;
            for(int i=0;i<n;i++){
                tuple curr=q.poll();
                int idx=curr.idx;
                TreeNode node=curr.node;
                if(node.left!=null){
                    q.add(new tuple(node.left,2*idx+1));
                }
                if(node.right!=null){
                    q.add(new tuple(node.right,2*idx+2));
                }
            }
            max=Math.max(max,r-l+1);
        }
        return max;
    }
}