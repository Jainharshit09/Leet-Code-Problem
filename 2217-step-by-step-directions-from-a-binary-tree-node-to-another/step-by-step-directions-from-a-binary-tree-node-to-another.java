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

    public boolean findpath(TreeNode root, int Target, StringBuilder ans) {
        if (root == null) {
            return false;
        }
        
        if (root.val == Target) {
            return true;
        }
        
        ans.append('L');
        if (findpath(root.left, Target, ans)) {
            return true;
        }
        ans.deleteCharAt(ans.length() - 1);

        ans.append('R');
        if (findpath(root.right, Target, ans)) {
            return true;
        }
        ans.deleteCharAt(ans.length() - 1);

        return false;
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder rootToSrc = new StringBuilder();
        StringBuilder rootToDest = new StringBuilder();

        if (!findpath(root, startValue, rootToSrc) || !findpath(root, destValue, rootToDest)) {
            return "";
        }

        int i = 0;
        while (i < rootToSrc.length() && i < rootToDest.length() && rootToSrc.charAt(i) == rootToDest.charAt(i)) {
            i++;
        }

        StringBuilder result = new StringBuilder();
        for (int j = i; j < rootToSrc.length(); j++) {
            result.append('U');
        }
        for (int j = i; j < rootToDest.length(); j++) {
            result.append(rootToDest.charAt(j));
        }
        return result.toString();
    }
}
