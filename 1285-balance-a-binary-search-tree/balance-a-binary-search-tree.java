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
    public TreeNode solve(int l,int h,int arr[]){
        if(l>h){
            return null;
        }
        int mid=l+(h-l)/2;
        TreeNode root=new TreeNode(arr[mid]);
        root.left=solve(l,mid-1,arr);
        root.right=solve(mid+1,h,arr);
        return root;
    }
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=height(root.left);
        int right=height(root.right);
        int myheight=Math.max(left,right)+1;
        return myheight;
    }
    public void inorder(TreeNode root,ArrayList<Integer>arr){
        if(root==null){
            return;
        }
        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
    }
    public TreeNode balanceBST(TreeNode root) {
        if(root==null){
            return root;
        }
        ArrayList<Integer> arr=new ArrayList<>();
        inorder(root,arr);
        // int left=height(root.left);
        // int right=height(root.right);
        // if(Math.abs(left-right)<=1){
        //     return root;
        // }
       int[] ans = arr.stream().mapToInt(i -> i).toArray();
        return solve(0,ans.length-1,ans);
    }
}