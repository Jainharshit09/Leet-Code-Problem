class Solution {
        public Map<Integer, List<Integer>> buildAdjList(int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            adjList.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adjList.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        return adjList;
    }
    public int diameter( Map<Integer, List<Integer>> adjList){
        // First BFS to find the farthest node from any arbitrary node (e.g., 0)
        List<Integer> farthestNode = BFS(adjList, 0);

        // Second BFS from the farthest node to determine the diameter
        farthestNode = BFS(adjList,farthestNode.get(0));
        return farthestNode.get(1);
    }

    public List<Integer> BFS(Map<Integer, List<Integer>> adjList,int sourceNode){
        Queue<Integer> que = new LinkedList<>();
        Map<Integer, Boolean> visited = new HashMap<>();
        que.add(sourceNode);
        visited.put(sourceNode, true);
        int maxDistance = 0, farthestNode = sourceNode;
        while(!que.isEmpty()){
             int size = que.size();
             for(int i=0;i<size;i++){
                int currentNode = que.poll();
                farthestNode=currentNode;
                 for (int neighbor : adjList.getOrDefault(currentNode, new ArrayList<>())) {
                    if (!visited.getOrDefault(neighbor, false)) {
                        visited.put(neighbor, true);
                        que.add(neighbor);
                    }
                 }
             }
                if (!que.isEmpty()) {
                maxDistance++;
            }
        }
        return Arrays.asList(farthestNode, maxDistance);
    }

    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        Map<Integer, List<Integer>> adj1 = buildAdjList(edges1);
        Map<Integer, List<Integer>> adj2 = buildAdjList(edges2);
        int d1=diameter(adj1);
        int d2=diameter(adj2);
        int ans=((d1+1)/2)+((d2+1)/2)+1;
        return Math.max(d1,Math.max(d2,ans));
    }
}