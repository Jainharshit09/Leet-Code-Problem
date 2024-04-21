class Solution {
    public boolean check(HashMap<Integer,ArrayList<Integer>> map,int s,int d, boolean[]visited){
        if(s==d){
            return true;
        }
        if(visited[s]==true){
            return false;
        }
        visited[s]=true;
        for(int it : map.getOrDefault(s, new ArrayList<Integer>())){
            if(check(map,it,d,visited)==true){
                return true;
            }
        }
        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
        for(int []edge:edges){
            int u =edge[0];
            int v=edge[1];
            if(!map.containsKey(u)){
                map.put(u,new ArrayList<>());
            }
            if(!map.containsKey(v)){
                map.put(v,new ArrayList<>());
            }
            map.get(u).add(v);
            map.get(v).add(u);
        }
        boolean visited[]=new boolean[n];
        return check(map,source,destination,visited);
    }
}