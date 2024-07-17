/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode deletehelp(TreeNode root,Set<Integer> set,ArrayList<TreeNode> result){
        if(root==null){
            return null;
        }
        root.left=deletehelp(root.left,set,result);
        root.right=deletehelp(root.right,set,result);
        if(set.contains(root.val)){
            if(root.left!=null){
                result.add(root.left);
            }

            if(root.right!=null){
                result.add(root.right);
            }
            return null;
            }
             else{
                return root;
        }
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        ArrayList<TreeNode> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int num : to_delete) {
            set.add(num);
        }
        deletehelp(root, set, result);
        if (!set.contains(root.val)) {
            result.add(root);
        }

        return result;
    }
}