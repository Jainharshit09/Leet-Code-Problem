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
 //create a undirected graph
 //store all leaf node
 //thrn find shotrest distance usinf bfs
 // in which we run till distance because if go more level means waste of time
 // curr!=leaf and set.contains leaf count++
 //remember the distance is add 2times because of unidrected graph 
 //in end count/2;
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
        Set<TreeNode> leafs=new HashSet<>();
        maketree(root,null,adj,leafs);
        int count=0;

        //for every leaf to count how many good leaf node are there
        for(TreeNode leaf:leafs){

            //finding shortest distance using bfs
            Queue<TreeNode>q=new LinkedList<>();
            Set<TreeNode>vis=new HashSet<>();
            q.add(leaf);
            vis.add(leaf);

            //this is optimal way to go only distance level
            for(int i=0;i<=distance;i++){
                int size=q.size();
                while(size-->0){
                    TreeNode curr=q.poll();

                    
                    if(curr!=leaf && leafs.contains(curr))count++;
                    for(TreeNode ngbr:adj.getOrDefault(curr,new ArrayList<>())){
                        if(!vis.contains(ngbr)){
                            q.add(ngbr);
                            vis.add(ngbr);
                        }
                    }
                }
            }
        }
        return count/2;
    }
}