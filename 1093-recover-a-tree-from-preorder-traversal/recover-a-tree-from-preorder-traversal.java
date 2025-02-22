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
    int n,i;
    public TreeNode solve(String str,int dept){
        if(i>=n){
            return null;
        }
        int j=i;
        while(j<n && str.charAt(j)=='-'){
            j++;
        }
        int dash=j-i;
        if(dash!=dept){
            return null;
        }
        i+=dash;
        int num=0;
        while(i<n &&Character.isDigit(str.charAt(i))){
            num=(num*10)+(str.charAt(i)-'0');
            i++;
        }
        TreeNode root=new TreeNode(num);
        root.left=solve(str,dept+1);
        root.right=solve(str,dept+1);
        return root;
    }
    public TreeNode recoverFromPreorder(String str) {
        n=str.length();
        i=0;
        return solve(str,0);
    }
}