class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int[] prevIdx = new int[nums.length];
        Arrays.fill(prevIdx, -1);
        int lastChosenIdx = 0;
        int maxL = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        prevIdx[i] = j;
                    }
                    if (dp[i] > maxL) {
                        maxL = dp[i];
                        lastChosenIdx = i;
                    }
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while (lastChosenIdx != -1) {
            res.add(nums[lastChosenIdx]);
            lastChosenIdx = prevIdx[lastChosenIdx];
        }
        return res;
    }
}