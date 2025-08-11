/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 //in serialize we can do create a string gor null use # and add , after every value 
 // to deserialize we use same concept used to check preodrder of serialize like that 
 //for deserialzie take a value and if we find , than insert in tree
 //move to it
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
          if(root==null){
            return "";
        }
        StringBuilder str=new StringBuilder();
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(curr==null){
                str.append("#");
                str.append(",");
                continue;
            }
            str.append(curr.val);
            str.append(",");
            q.add(curr.left);
            q.add(curr.right);
        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0)return null;
        String values[]=data.split(",");
        TreeNode root=new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        for(int i=1;i<values.length;i++){
            TreeNode parent=q.poll();
            if(!values[i].equals("#")){
                TreeNode left=new TreeNode(Integer.parseInt(values[i]));
                parent.left=left;
                q.add(left);
            }
            i++;
            if(!values[i].equals("#")){
                TreeNode right=new TreeNode(Integer.parseInt(values[i]));
                parent.right=right;
                q.add(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));