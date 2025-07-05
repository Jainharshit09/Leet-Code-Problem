//m is row and n is col
// cost is i+1 * j+1
// for odd directly go down or bottom
// for even pay wait cost 
// start with 0,0 and move till m-1 and n-1
// only move on odd second
//can we solve using dp 3 dp like i j partiry
class Solution {
    long dp[][][];

    public long rec(int[][] waitCost, int i, int j, int parity) {
        int n = waitCost.length;
        int m = waitCost[0].length;

        if (i == n - 1 && j == m - 1) return 0;
        if (i >= n || j >= m) return Long.MAX_VALUE;
        if (dp[i][j][parity] != -1) return dp[i][j][parity];

        long ans;

        if (parity == 1) { 
            //we use i+2 and j+1  because  calculating the cost of the destination cell i+1+1 that why writing i+2
            long r = rec(waitCost, i + 1, j, parity ^ 1);
            if (r != Long.MAX_VALUE) r += (i + 2) * (j + 1);
            long d = rec(waitCost, i, j + 1, parity ^ 1);
            if (d != Long.MAX_VALUE) d += (i + 1) * (j + 2);
            ans = Math.min(r, d);
        } else { 
            ans = rec(waitCost, i, j, parity ^ 1) + waitCost[i][j];
        }

        return dp[i][j][parity] = ans;
    }

    public long minCost(int m, int n, int[][] waitCost) {
        dp = new long[m][n][2];
        for (long[][] row : dp) {
            for (long[] col : row) {
                Arrays.fill(col, -1);
            }
        }
        return 1+rec(waitCost, 0, 0, 1);
    }
}
