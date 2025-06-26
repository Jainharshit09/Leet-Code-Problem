//find min time to traverse all having apple 
// again come to root
// having 3 choice like children ka children ,children , or nahi ha
//like it focusing on dfs side of graph
// no need of vis because given a tree so means no cycle
//
class Solution {

    public int dfs(HashMap<Integer,List<Integer>>adj,int curr,int parent,List<Boolean> hasApple){
        int time=0;
        for(int child:adj.getOrDefault(curr,new ArrayList<>())){
            if(child==parent)continue;
            int time_from_child=dfs(adj,child,curr,hasApple);
            if((time_from_child>0) || (hasApple.get(child)==true)){
                time+=2+time_from_child;
            }
        }
        return time;
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        
        // creating a adj graph
        HashMap<Integer,List<Integer>>adj=new HashMap<>();
        for(int i=0;i<n;i++){
            adj.put(i,new ArrayList<>());
        }
        for(int edge[]:edges){
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return dfs(adj,0,-1,hasApple);
    }
}