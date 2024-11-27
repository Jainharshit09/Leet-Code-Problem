class Solution {
    public int dijkstra(List<List<Integer>> graph, int n) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int distances[] = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[0] = 0;
        pq.offer(new int[] { 0, 0 });
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int distance = current[0];
            int node = current[1];
            if (distance > distances[node]) {
                continue;
            }
            for (int neighbor : graph.get(node)) {
                int newDist = distance + 1; // All edges have weight 1
                if (newDist < distances[neighbor]) {
                    distances[neighbor] = newDist;
                    pq.offer(new int[] { newDist, neighbor });
                }
            }
        }
        return distances[n-1];

    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i <n-1; i++) {
            graph.get(i).add(i + 1);
        }
        int ans[]=new int [queries.length];
        for(int i=0;i<queries.length;i++){
            int u=queries[i][0];
            int v=queries[i][1];
            if (!graph.get(u).contains(v)) {
                graph.get(u).add(v);
            }
            ans[i]=dijkstra(graph,n);
        }
        return ans;
    }
}