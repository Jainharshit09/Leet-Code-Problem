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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Set<Integer> set=new HashSet<>();
        HashMap<Integer,TreeNode> map=new HashMap<>();
        TreeNode root=null;
        for(int i=0;i<descriptions.length;i++){
            int parent=descriptions[i][0];
            int child=descriptions[i][1];
              boolean left = descriptions[i][2] == 1;;
            map.putIfAbsent(parent, new TreeNode(parent));
            map.putIfAbsent(child, new TreeNode(child));
            if(left){
                map.get(parent).left=map.get(child);
            }
            else{
                 map.get(parent).right=map.get(child);
            }
            set.add(child);
        }
        for(int[] description : descriptions){
             int parent = description[0];
               if (!set.contains(parent)) {
                return map.get(parent);
            }
        }
        return null;
    }
}