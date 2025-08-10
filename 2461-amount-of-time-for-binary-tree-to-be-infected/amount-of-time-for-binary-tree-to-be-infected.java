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
        private void buildGraph(TreeNode node, TreeNode parent, Map<Integer, List<Integer>> graph) {
        if (node == null) return;
        graph.putIfAbsent(node.val, new ArrayList<>());
        if (parent != null) {
            graph.get(node.val).add(parent.val);
            graph.get(parent.val).add(node.val);
        }
        buildGraph(node.left, node, graph);
        buildGraph(node.right, node, graph);
    }
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, List<Integer>>adj=new HashMap<>();
        buildGraph(root,null,adj);
        int count=0;
        Queue<Integer>q=new LinkedList<>();
        Set<Integer>vis=new HashSet<>();
        q.add(start);
        vis.add(start);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int curr=q.poll();
                for(int ngbr:adj.getOrDefault(curr,new ArrayList<>())){
                    if(!vis.contains(ngbr)){
                        q.add(ngbr);
                        vis.add(ngbr);
                    }
                }
            }
            count++;
        }
        return count-1;
    }
}