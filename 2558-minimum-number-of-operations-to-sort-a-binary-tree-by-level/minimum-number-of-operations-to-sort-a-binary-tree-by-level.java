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
    int solve(ArrayList<Integer> original){
        int swaps = 0;
    ArrayList<Integer> target = new ArrayList<>(original);
    Collections.sort(target);

    Map<Integer, Integer> pos = new HashMap<>();
    for (int i = 0; i < original.size(); i++) {
        pos.put(original.get(i), i);
    }

    for (int i = 0; i < original.size(); i++) {
        if (!original.get(i).equals(target.get(i))) {
            swaps++;
            int curPos = pos.get(target.get(i));
            pos.put(original.get(i), curPos);
            original.set(curPos, original.get(i));
            original.set(i, target.get(i));
        }
    }
    return swaps;
    }
    public int minimumOperations(TreeNode root) {
        int ans=0;
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n=q.size();
            ArrayList<Integer>arr=new ArrayList<>();
            for(int i=0;i<n;i++){
                 TreeNode curr=q.poll();
                arr.add(curr.val);
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
            ans+=solve(arr);
        }
        return ans;
    }
}