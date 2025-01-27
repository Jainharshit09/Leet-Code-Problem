class Solution {
    public boolean dfs(HashMap<Integer,List<Integer>> graph,int start,int end,boolean[] vis){
        vis[start]=true;
        if(start==end){
            return true;
        }
         boolean isReachable = false;
         for (int adjNode : graph.getOrDefault(start, new ArrayList<>())) {
            if(!vis[adjNode]){
                isReachable = isReachable || dfs(graph, adjNode, end, vis);
            }
         }
         return isReachable;
    }
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] preq, int [][] queries) {
        List<Boolean> ans= new ArrayList<>();
        HashMap<Integer,List<Integer>>adjList=new HashMap<>();
        int n=preq.length;
        int Q = queries.length;
        for (int[] edge : preq) {
            adjList.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
        }
        for(int i=0;i<Q;i++){
            int u=queries[i][0];
            int v=queries[i][1];
            boolean vis[]=new boolean[numCourses];
            ans.add(dfs(adjList,u,v,vis));
        }
        return ans;
    }
}