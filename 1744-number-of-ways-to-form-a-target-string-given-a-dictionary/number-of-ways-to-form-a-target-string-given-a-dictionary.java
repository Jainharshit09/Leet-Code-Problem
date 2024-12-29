import java.util.*;

class Solution {
    int m, k;
    long[][] t;
    final int MOD = 1_000_000_007;

    public int solve(int i, int j, long[][] dp, String target) {
        if (i == m) {
            return 1;
        }
        if (j == k) {
            return 0;
        }
        if (t[i][j] != -1) {
            return (int) t[i][j];
        }
        int not_taken = solve(i, j + 1, dp, target);
        int taken = 0;
        if (dp[target.charAt(i) - 'a'][j] > 0) {
            taken = (int) ((dp[target.charAt(i) - 'a'][j] * (long) solve(i + 1, j + 1, dp, target)) % MOD);
        }
        return (int) (t[i][j] = (not_taken + taken) % MOD);
    }

    public int numWays(String[] words, String target) {
        m = target.length();
        k = words[0].length();
        t = new long[m][k];
        for (long[] row : t) {
            Arrays.fill(row, -1);
        }
        long[][] dp = new long[26][k];
        for (int col = 0; col < k; col++) {
            for (String word : words) {
                char ch = word.charAt(col);
                dp[ch - 'a'][col]++;
            }
        }
        return solve(0, 0, dp, target);
    }
}
