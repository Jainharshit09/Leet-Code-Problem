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

 //similar we do in top left bottom
 // i which create a map <Integer,Map<Integer,PriorityQueue<Integer>>> map becuse we need in vertical order all element so create a TreeMap not map because treemap will be ordered map means in sorted order
 class Tuple{
    TreeNode node;
    int row;
    int col;
    public Tuple(TreeNode node,int row,int col){
        this.node=node;
        this.col=col;
        this.row=row;
    }
 }
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>>ans=new ArrayList<>();
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>>map=new TreeMap<>();
        Queue<Tuple>q=new LinkedList<>();
        q.add(new Tuple(root,0,0));
        while(!q.isEmpty()){
            Tuple curr=q.poll();
            TreeNode node=curr.node;
            int x=curr.col;
            int y=curr.row;
             if(!map.containsKey(x)){
                map.put(x,new TreeMap<>());
            }
             if(!map.get(x).containsKey(y)){
                map.get(x).put(y,new PriorityQueue<>());
             }
             map.get(x).get(y).add(node.val);
             if(node.left!=null){
                q.add(new Tuple(node.left,y+1,x-1));
             }
             if(node.right!=null){
                q.add(new Tuple(node.right,y+1,x+1));
             }
        }
    for(TreeMap<Integer,PriorityQueue<Integer>>entry:map.values()){
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer>nodes:entry.values()){
                while(!nodes.isEmpty()){
                    ans.get(ans.size()-1).add(nodes.poll());
                }
            }
        }
        return ans;
    }
}