class Pair implements Comparable<Pair> {
    int x, y, effort;

    public Pair(int x, int y, int effort) {
        this.x = x;
        this.y = y;
        this.effort = effort;
    }

    @Override
    public int compareTo(Pair p) {
        return Integer.compare(this.effort, p.effort);
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] effort = new int[n][m];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        // Initialize effort array with infinity
        for (int i = 0; i < n; i++) {
            Arrays.fill(effort[i], Integer.MAX_VALUE);
        }
        
        effort[0][0] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int x = curr.x;
            int y = curr.y;

            if (x == n - 1 && y == m - 1) {
                return effort[n - 1][m - 1];
            }

            for (int[] dir : directions) {
                int new_x = x + dir[0];
                int new_y = y + dir[1];

                if (new_x >= 0 && new_y >= 0 && new_x < n && new_y < m) {
                    int new_effort = Math.max(curr.effort, Math.abs(heights[new_x][new_y] - heights[x][y]));

                    if (new_effort < effort[new_x][new_y]) {
                        effort[new_x][new_y] = new_effort;
                        pq.add(new Pair(new_x, new_y, new_effort));
                    }
                }
            }
        }

        return effort[n - 1][m - 1];
    }
}