class Solution {
    public boolean isBipartite(HashMap<Integer, List<Integer>> adj, int curr, int colors[], int currColor) {
        colors[curr] = currColor;
        for (int ngbr : adj.get(curr)) {
            if (colors[ngbr] == colors[curr]) {
                return false;
            }
            if (colors[ngbr] == -1) {
                if (!isBipartite(adj, ngbr, colors, 1 - currColor)) {
                    return false;
                }
            }
        }
        return true;
    }

        public int bfs(Map<Integer, List<Integer>> adj, int currNode, int n) {
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        que.add(currNode);
        visited[currNode] = true;

        int level = 1;
        while (!que.isEmpty()) {
            int size = que.size();
            while (size-- > 0) {
                int curr = que.poll();
                
                for (int ngbr : adj.get(curr)) {
                    if (visited[ngbr]) continue;
                    
                    que.add(ngbr);
                    visited[ngbr] = true;
                }
            }
            level++;
        }
        return level - 1;
    }


    public int getMax(Map<Integer, List<Integer>> adj, int curr, boolean[] visited, int[] levels) {
        int max = levels[curr];
        visited[curr] = true;
        for (int ngbr : adj.get(curr)) {
            if (!visited[ngbr]) {
                max = Math.max(max, getMax(adj, ngbr, visited, levels));
            }
        }
        return max;
    }

    public int magnificentSets(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int colors[] = new int[n + 1];
        Arrays.fill(colors, -1);
        for (int i = 1; i <= n; i++) {
            if (colors[i] == -1) {
                if (!isBipartite(adj, i, colors, 1)) {
                    return -1;
                }
            }
        }
        int level[] = new int[n + 1];
        for (int node = 1; node <= n; node++) {
            level[node] = bfs(adj, node, n);
        }
        boolean vis[] = new boolean[n + 1];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                ans += getMax(adj, i, vis, level);
            }
        }
        return ans;
    }
}
