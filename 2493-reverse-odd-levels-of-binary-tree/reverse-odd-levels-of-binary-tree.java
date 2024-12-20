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
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root==null){
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int level=0;
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<TreeNode> levelNodes = new ArrayList<>();
            List<Integer> levelValues = new ArrayList<>();
            for(int i=0;i<levelSize;i++){
                TreeNode node = queue.poll();
                levelNodes.add(node);
                levelValues.add(node.val);
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            if(level%2==1){
                Collections.reverse(levelValues);
                for(int i=0;i<levelNodes.size();i++){
                    levelNodes.get(i).val= levelValues.get(i);
                }
            }
            level++;
        }
        return root;
    }
}