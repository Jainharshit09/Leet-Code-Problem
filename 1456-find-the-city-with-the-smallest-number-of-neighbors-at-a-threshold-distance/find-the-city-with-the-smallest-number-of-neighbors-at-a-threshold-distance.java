class Solution {
    public int find(int n, int[][] spm, int threshold) {
        int ans = -1;
        int r = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && spm[i][j] <= threshold) {
                    count++;
                }
            }
            if (count <= r) {
                r = count;
                ans = i;
            }
        }
        return ans;
    }
    void dijkstra(int n, List<List<int[]>> adj, int[] result, int S) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[] { 0, S });
        Arrays.fill(result, Integer.MAX_VALUE);
        result[S] = 0;

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int d = top[0];
            int node = top[1];

            if (adj.get(node) == null)
                continue;

            for (int[] p : adj.get(node)) {
                int adjNode = p[0];
                int dist = p[1];

                if (d + dist < result[adjNode]) {
                    result[adjNode] = d + dist;
                    pq.add(new int[] { d + dist, adjNode });
                }
            }
        }
    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] spm = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(spm[i], Integer.MAX_VALUE);
        }

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new int[] { v, w });
            adj.get(v).add(new int[] { u, w });
        }

        for (int i = 0; i < n; i++) {
            dijkstra(n, adj, spm[i], i);
        }

        return find(n, spm, distanceThreshold);
    }
}
