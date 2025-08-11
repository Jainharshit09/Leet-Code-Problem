// Make adjacency list from edges.
// Generate all subsets of nodes with size ≥ 2.
// For each subset:
// Check if it is connected using BFS or DFS.
// If connected:Find maximum distance between any two nodes in the subset.
// If max distance is d, do count[d] += 1.
// At the end, return the count array for distances from 1 to n−1.
class Solution {
    //find all subset
    public List<List<Integer>> generateSubsets(int n) {
        List<List<Integer>> subsets = new ArrayList<>();
        int total = 1 << n; // 2^n subsets
        for (int mask = 1; mask < total; mask++) {
            List<Integer> subset = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subset.add(i + 1); // nodes numbered from 1 to n
                }
            }
            if (subset.size() >= 2) {
                subsets.add(subset);
            }
        }
        return subsets;
    }

    //checking is connected
     public boolean isConnected(List<Integer> subset, HashMap<Integer, List<Integer>> adj) {
        Set<Integer> subsetSet = new HashSet<>(subset);
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(subset.get(0));
        visited.add(subset.get(0));
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int neighbor : adj.get(curr)) {
                if (subsetSet.contains(neighbor) && !visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }

        return visited.size() == subset.size();
    }

    //getting getMaxDistance
    public int getMaxDistance(List<Integer> subset, HashMap<Integer, List<Integer>> adj) {
        int maxDist = 0;
        Set<Integer> subsetSet = new HashSet<>(subset);

        for (int start : subset) {
            Queue<Integer> queue = new LinkedList<>();
            Map<Integer, Integer> dist = new HashMap<>();
            queue.offer(start);
            dist.put(start, 0);

            while (!queue.isEmpty()) {
                int curr = queue.poll();
                for (int neighbor : adj.get(curr)) {
                    if (subsetSet.contains(neighbor) && !dist.containsKey(neighbor)) {
                        dist.put(neighbor, dist.get(curr) + 1);
                        queue.offer(neighbor);
                        maxDist = Math.max(maxDist, dist.get(neighbor));
                    }
                }
            }
        }

        return maxDist;
    }

    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 1; i <= n; i++)
            adj.put(i, new ArrayList<>());
        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        List<List<Integer>> subsets = generateSubsets(n);
        int count[] = new int[n - 1];
        for (List<Integer> subset : subsets) {
            if (isConnected(subset, adj)) {
                int maxDist = getMaxDistance(subset, adj);
                if (maxDist >= 1 && maxDist <= n - 1) {
                    count[maxDist - 1]++;
                }
            }
        }

        return count;
    }
}