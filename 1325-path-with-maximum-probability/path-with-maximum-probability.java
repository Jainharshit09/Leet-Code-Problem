import java.util.*;

class Pair implements Comparable<Pair> {
    double wt;
    int v;

    public Pair(double wt, int v) {
        this.wt = wt;
        this.v = v;
    }

    @Override
    public int compareTo(Pair other) {
        return Double.compare(other.wt, this.wt);
    }
}

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<Pair>> graph = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new Pair(prob, v));
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(new Pair(prob, u));
        }

        double[] result = new double[n];
        result[start_node] = 1.0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(1.0, start_node));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            double curProb = curr.wt;
            int curNode = curr.v;

            if (curNode == end_node) {
                return curProb;
            }

            for (Pair nxt : graph.getOrDefault(curNode, new ArrayList<>())) {
                int nxtNode = nxt.v;
                double pathProb = nxt.wt;
                if (curProb * pathProb > result[nxtNode]) {
                    result[nxtNode] = curProb * pathProb;
                    pq.add(new Pair(result[nxtNode], nxtNode));
                }
            }
        }
        return 0.0;
    }
}
