import java.util.*;

class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;
        boolean[] vis = new boolean[n];      // visited boxes
        boolean[] hasBox = new boolean[n];   // whether we have this box
        Queue<Integer> q = new LinkedList<>();
        int ans = 0;

        // Step 1: mark initialBoxes as "have"
        for (int box : initialBoxes) {
            hasBox[box] = true;
            if (status[box] == 1) {
                q.offer(box);
                vis[box] = true;
            }
        }

        // BFS
        while (!q.isEmpty()) {
            int curr = q.poll();
            ans += candies[curr];
            candies[curr] = 0;

            // Step 2: process containedBoxes FIRST
            for (int box : containedBoxes[curr]) {
                hasBox[box] = true;
                if (status[box] == 1 && !vis[box]) {
                    q.offer(box);
                    vis[box] = true;
                }
            }

            // Step 3: then process keys
            for (int key : keys[curr]) {
                if (status[key] == 0) {
                    status[key] = 1;
                }
                if (hasBox[key] && !vis[key]) {
                    q.offer(key);
                    vis[key] = true;
                }
            }
        }

        return ans;
    }
}
