class Solution {
    int dp[][];
    
    public int solve(int n, int egg) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (egg == 1) {
            return n;
        }
        if (dp[n][egg] != Integer.MAX_VALUE) {
            return dp[n][egg];
        }
        
        int ans = Integer.MAX_VALUE;
        int low = 1, high = n;
        
        // Perform binary search to minimize the worst-case number of drops
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int breakCase = solve(mid - 1, egg - 1);  // Egg breaks
            int notBreakCase = solve(n - mid, egg);   // Egg doesn't break
            int temp = 1 + Math.max(breakCase, notBreakCase);
            
            // We need to minimize the maximum number of drops
            ans = Math.min(ans, temp);
            
            if (breakCase > notBreakCase) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return dp[n][egg] = ans;
    }
    
    public int superEggDrop(int k, int n) {
        dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        return solve(n, k);
    }
}
