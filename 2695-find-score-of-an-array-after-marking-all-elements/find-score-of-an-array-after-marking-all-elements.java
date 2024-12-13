class Solution {
    public long findScore(int[] nums) {
        long ans = 0;
        int n = nums.length;
        boolean[] vis = new boolean[n];
        Arrays.fill(vis, false);

        // Priority Queue to sort by value first, then by index
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        // Add elements to the priority queue
        for (int i = 0; i < n; i++) {
            pq.add(new int[]{nums[i], i});
        }

        // Process elements
        while (!pq.isEmpty()) {
            int[] dir = pq.poll();
            int curr = dir[0];
            int index = dir[1];

            if (!vis[index]) {
                ans += (long) curr;
                vis[index] = true;
                if (index - 1 >= 0) {
                    vis[index - 1] = true;
                }
                if (index + 1 < n) {
                    vis[index + 1] = true;
                }
            }
        }

        return ans;
    }
}