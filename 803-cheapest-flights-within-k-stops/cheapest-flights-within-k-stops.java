class Pair{
   int dst;
   int wt;
    public Pair(int dst,int wt){
        this.dst=dst;
        this.wt=wt;
    }

}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<Pair> pq = new LinkedList<>();
        pq.add(new Pair(src, 0));
        
        int steps = 0;

        while (!pq.isEmpty()) {
            int size = pq.size();
            for (int i = 0; i < size; i++) {
                Pair curr = pq.poll();
                int u = curr.dst;
                int wt = curr.wt;

                for (int[] flight : flights) {
                    if (flight[0] == u) {
                        int new_cost = wt + flight[2];
                        if (new_cost < dist[flight[1]]) {
                            dist[flight[1]] = new_cost;
                            pq.add(new Pair(flight[1], new_cost));
                        }
                    }
                }
            }
            
            steps++;
            if (steps > k) { // Check if we have exceeded the allowed number of stops
                break;
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}