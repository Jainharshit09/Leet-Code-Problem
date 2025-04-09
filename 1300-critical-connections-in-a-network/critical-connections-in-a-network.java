import java.util.*;

class Solution {
    public void dfs(int node, int parent, int[] timer, int[] dis, int[] low, boolean[] vis, 
                    List<List<Integer>> ans, List<List<Integer>> adj) {
        vis[node] = true;
        dis[node] = low[node] = timer[0]++;
        
        for (int ngbr : adj.get(node)) {
            if (ngbr == parent) continue;
            
            if (!vis[ngbr]) {
                dfs(ngbr, node, timer, dis, low, vis, ans, adj);
                low[node] = Math.min(low[node], low[ngbr]);

                // Check if it's a bridge
                if (low[ngbr] > dis[node]) {
                    ans.add(Arrays.asList(node, ngbr));
                }
            } else {
                low[node] = Math.min(low[node], dis[ngbr]);
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        // Construct adjacency list
        for (List<Integer> edge : connections) {
            int u = edge.get(0), v = edge.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] dis = new int[n], low = new int[n];
        boolean[] vis = new boolean[n];
        List<List<Integer>> ans = new ArrayList<>();
        int[] timer = {0};  // Using an array to maintain a global counter
        
        dfs(0, -1, timer, dis, low, vis, ans, adj);
        return ans;
    }
}
