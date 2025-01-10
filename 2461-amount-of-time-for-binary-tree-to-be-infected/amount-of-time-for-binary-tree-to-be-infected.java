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
    public void build(HashMap<Integer,ArrayList<Integer>>graph,TreeNode root){
        if(root==null){
            return ;
        }
        // Ensure the node exists in the graph
        graph.putIfAbsent(root.val, new ArrayList<>());
        if(root.left!=null){
            graph.putIfAbsent(root.left.val, new ArrayList<>());
            graph.get(root.val).add(root.left.val);
            graph.get(root.left.val).add(root.val);
            build(graph,root.left);
        }
        if(root.right!=null){
            graph.putIfAbsent(root.right.val, new ArrayList<>());
            graph.get(root.val).add(root.right.val);
            graph.get(root.right.val).add(root.val);
            build(graph,root.right);
        }
    }
    public int bfs(HashMap<Integer,ArrayList<Integer>>graph,int start){
        Queue<Integer>q=new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int minutes = 0;
        q.add(start);
        visited.add(start);
        while(!q.isEmpty()){
            int size=q.size();
             boolean temp = false;
             for(int i=0;i<size;i++){
                int curr=q.poll();
                for(int neighbor:graph.get(curr)){
                     if (!visited.contains(neighbor)){
                        visited.add(neighbor);
                        q.add(neighbor);
                        temp=true;
                     }
                }
             }
             if(temp){
                minutes++;
             }
        }
        return minutes;
    }
    public int amountOfTime(TreeNode root, int start) {
        HashMap<Integer,ArrayList<Integer>>graph=new HashMap<>();
        build(graph,root);
        return bfs(graph,start);
    }
}