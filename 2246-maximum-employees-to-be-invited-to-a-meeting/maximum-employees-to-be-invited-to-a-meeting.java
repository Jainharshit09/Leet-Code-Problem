class Solution {
    public int BFS(int start, Map<Integer, List<Integer>> adj ,boolean[] vis){
         Queue<int[]> queue = new LinkedList<>();
         queue.add(new int[]{start, 0});
          int maxDistance = 0;
          while(!queue.isEmpty()){
            int[] current = queue.poll();
            int currNode = current[0];
            int dist = current[1];
             for (int ngbr : adj.getOrDefault(currNode, new ArrayList<>())){
                if(!vis[ngbr]){
                    vis[ngbr]=true;
                     queue.add(new int[]{ngbr, dist + 1});
                      maxDistance = Math.max(maxDistance, dist + 1);
                }
             }
          }
        return maxDistance;
    }
    public int maximumInvitations(int[] fav) {
        int n=fav.length;
        Map<Integer, List<Integer>> adj = new HashMap<>();
           for (int i = 0; i < n; i++) {
            int u = i;
            int v = fav[i];
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        int longestCycleEmplCount = 0;
        int happyCoupleEmplCount = 0;
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                 Map<Integer, Integer> mp = new HashMap<>();
                 int currNode = i;
                 int currNodeCount = 0;
                 while(!visited[currNode]){
                    visited[currNode] = true;
                    mp.put(currNode, currNodeCount);
                    int nextNode=fav[currNode];
                    currNodeCount++;
                    if (mp.containsKey(nextNode)) { // Cycle detected
                        int cycleLength = currNodeCount - mp.get(nextNode);
                        longestCycleEmplCount = Math.max(longestCycleEmplCount, cycleLength);

                        if (cycleLength == 2) { // Happy couple case
                            boolean[] visitedNodes = new boolean[n];
                            visitedNodes[currNode] = true;
                            visitedNodes[nextNode] = true;
                            happyCoupleEmplCount += 2 + BFS(currNode, adj, visitedNodes) + BFS(nextNode, adj, visitedNodes);
                        }
                        break;
                    }
                    currNode=nextNode;
                 }
            }
        }
        return Math.max(happyCoupleEmplCount, longestCycleEmplCount);
    }
}