class Solution {
    public int solve(int[] days, int[] cost, int n, int i, int[] memo) {
        if (i >= n) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }

        int day1 = cost[0] + solve(days, cost, n, i + 1, memo);

        int j = i;
        int max_day = days[i] + 7;
        while (j < n && days[j] < max_day) {
            j++;
        }
        int day7 = cost[1] + solve(days, cost, n, j, memo);

        int k = i;
        int max_day_30 = days[i] + 30;
        while (k < n && days[k] < max_day_30) {
            k++;
        }
        int day30 = cost[2] + solve(days, cost, n, k, memo);

        memo[i] = Math.min(day1, Math.min(day7, day30));
        return memo[i];
    }

    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] memo = new int[n];
        for (int i = 0; i < n; i++) {
            memo[i] = -1;
        }
        return solve(days, costs, n, 0, memo);
    }
}
