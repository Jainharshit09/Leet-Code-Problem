class Solution {
    int dp[][];

    public int solve(int[] nums, int left, int right) {
        if (left + 1 == right)
            return 0;

        if (dp[left][right] != -1)
            return dp[left][right];

        int maxCoins = 0;
        for (int i = left + 1; i < right; i++) {
            int coins = nums[left] * nums[i] * nums[right];
            coins += solve(nums, left, i) + solve(nums, i, right);
            maxCoins = Math.max(maxCoins, coins);
        }

        dp[left][right] = maxCoins;
        return maxCoins;
    }

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = arr[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }
        dp = new int[n + 2][n + 2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(arr, 0, n + 1);
    }
}