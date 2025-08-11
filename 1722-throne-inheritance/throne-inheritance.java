//easy question
// this is toward the hashmap and dfs
// like store all king and child in map
// death will add in store
// for order call dfs it only check that root is not in set other wise add in list
class ThroneInheritance {
    HashMap<String,List<String>>map;
    Set<String>set;
    String root;
    public ThroneInheritance(String kingName) {
        map=new HashMap<>();
        set=new HashSet<>();
        map.putIfAbsent(kingName, new ArrayList<>());
        root=kingName;
    }
    
    public void birth(String parentName, String childName) {
        map.get(parentName).add(childName);
        map.putIfAbsent(childName,new ArrayList<>());   
    }
    
    public void death(String name) {
        set.add(name);
    }
    
    public List<String> getInheritanceOrder() {
        List<String>list=new ArrayList<>();
        dfs(root,list);
        return list;
    }
    public void dfs(String root,List<String>list){
        if(!set.contains(root)){
            list.add(root);
        }
        for(String child:map.get(root)){
            dfs(child,list);
        }
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */