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
class FindElements {
    Set<Integer>set;
    public void bfs(TreeNode root){
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        int x=0;
        root.val = 0;
        set.add(0);
        while(!q.isEmpty()){
                TreeNode curr=q.poll();
                if(curr.left!=null){
                    curr.left.val = 2 * curr.val + 1; 
                    set.add(curr.left.val);
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    curr.right.val = 2 * curr.val + 2; 
                    set.add(curr.right.val);
                    q.add(curr.right);
                }
                x++;
        }
        
    }
    public FindElements(TreeNode root) {
        set=new HashSet<>();
        bfs(root);
    }
    
    public boolean find(int target) {
        if(set.contains(target)){
            return true;
        }
        return false;
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */