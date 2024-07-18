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
    public void maketree(TreeNode root,TreeNode prev, Map<TreeNode,List<TreeNode>> adj,Set<TreeNode> leaf){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            leaf.add(root);
        }
        if(prev!=null){
            adj.computeIfAbsent(root, k -> new ArrayList<>()).add(prev);
            adj.computeIfAbsent(prev, k -> new ArrayList<>()).add(root);
        }
        maketree(root.left,root,adj,leaf);
        maketree(root.right,root,adj,leaf);
    }
    public int countPairs(TreeNode root, int distance) {
        Map<TreeNode,List<TreeNode>> adj=new HashMap<>();
        Set<TreeNode> leaf=new HashSet<>();
        maketree(root,null,adj,leaf);
        int count=0;
        for(TreeNode leafs:leaf){
            Queue<TreeNode> q = new LinkedList<>();
            Set<TreeNode> vis = new HashSet<>();
            q.add(leafs);
            vis.add(leafs);
            for(int i=0;i<=distance;i++){
                int size=q.size();
                while(size-->0){
                    TreeNode curr=q.poll();
                    if(curr!=leafs && leaf.contains(curr)){
                        count++;
                    }
                    for(TreeNode neighbours:adj.getOrDefault(curr, new ArrayList<>())){
                        if(!vis.contains(neighbours)){
                            q.add(neighbours);
                            vis.add(neighbours);
                        }
                    }

                }
            }

        }
        return count/2;

    }
}