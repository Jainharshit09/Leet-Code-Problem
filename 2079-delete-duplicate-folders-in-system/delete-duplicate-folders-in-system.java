//we can use trie to create a folder
// than store in map of theresubfolder
// check that if subfolder value>1 remove that they are copy
import java.util.*;
class Solution {
    static class Node{
        String val;
        String subfolder;
        Map<String,Node>child;
        public Node(String val){
            this.val=val;
            subfolder="";
            child=new HashMap<>();
        }
    }

    private Node getNode(String val){
            return new Node(val);
    }
    private  void insert(Node root,List<String> path){
        for(String folder:path){
            root.child.putIfAbsent(folder,getNode(folder));
            root=root.child.get(folder);
        }
    }
    public String populateNodes(Node root,Map<String, Integer> subFolderMap){
        List<Map.Entry<String, String>> subFolderPaths = new ArrayList<>();
        for(Map.Entry<String,Node> entry:root.child.entrySet()){
            String subFolderResult=populateNodes(entry.getValue(),subFolderMap);
            subFolderPaths.add(new AbstractMap.SimpleEntry<>(entry.getKey(), subFolderResult));
        }
        subFolderPaths.sort(Comparator.comparing(Map.Entry::getKey));

        StringBuilder completePath = new StringBuilder();//this is the subfolder of curr root which we will from children
        
        for(Map.Entry<String,String>entry:subFolderPaths){
            completePath.append("(").append(entry.getKey()).append(entry.getValue()).append(")");
        }
        root.subfolder=completePath.toString();
        if(!completePath.toString().isEmpty()){
            subFolderMap.put(completePath.toString(), subFolderMap.getOrDefault(completePath.toString(), 0) + 1);
        }
        return completePath.toString();
    }

    public void removeDuplicates(Node root,Map<String,Integer>subFolderMap){
         Iterator<Map.Entry<String, Node>> it = root.child.entrySet().iterator(); // used to itreat a map
         while(it.hasNext()){
            Map.Entry<String, Node> entry = it.next();
            Node child = entry.getValue();
            if(!child.subfolder.isEmpty() && subFolderMap.get(child.subfolder)>1){
                it.remove();
            }
            else{
                 removeDuplicates(child, subFolderMap);
            }
         }
    }

    public void constructResult(Node root, List<String>path, List<List<String>>result){
          for (Map.Entry<String, Node> entry : root.child.entrySet()){
            path.add(entry.getKey());
            result.add(new ArrayList<>(path));
            constructResult(entry.getValue(),path,result);
            path.remove(path.size()-1);
          }
    }

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        Node root=getNode("/");

        //construct trie
        for(List<String>list:paths){
            insert(root,list);
        }

         Map<String, Integer> subFolderMap = new HashMap<>(); 
         populateNodes(root,subFolderMap);

         removeDuplicates(root,subFolderMap);

         List<List<String>>result=new ArrayList<>();
         List<String>path=new ArrayList<>();
         constructResult(root,path,result);
         return result;

    }
}