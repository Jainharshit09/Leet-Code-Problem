class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] preq, int [][] queries) {
        HashMap<Integer,List<Integer>>adjList=new HashMap<>();
        int indegree[]=new int[numCourses];
        int n=preq.length;
        int Q = queries.length;
        for (int[] edge : preq) {
            adjList.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            indegree[edge[1]]++;
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        Map<Integer,Set<Integer>>set=new HashMap<>();
        while(!q.isEmpty()){
            int node=q.poll();
            for(int ngbr:adjList.getOrDefault(node, new ArrayList<>())) {
                set.computeIfAbsent(ngbr, k -> new HashSet<>()).add(node);
                set.get(ngbr).addAll(set.getOrDefault(node, new HashSet<>()));
                indegree[ngbr]--;
                if( indegree[ngbr]==0){
                    q.add(ngbr);
                }
            }
        }
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            int src = query[0];
            int dest = query[1];
            result.add(set.getOrDefault(dest, new HashSet<>()).contains(src));
        }
        return result;
    }
}