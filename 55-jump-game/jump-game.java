class Solution {
    int dp[]=new int [10001];
    public boolean solve(int nums[], int n, int idx) {
        if (idx == n - 1) {
            return true;
        }
        if (idx >= n) {
            return true;
        }
        if(dp[idx]!=-1){
            return dp[idx] == 1;
        }
        for (int i = 1; i <= nums[idx]; i++) {
            if(solve(nums,n,idx + i)==true) {
                dp[idx]=1;
                return true;
            }
        }
        dp[idx]=0;
        return false;
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        Arrays.fill(dp,-1);
        return solve(nums, n, 0);
    }
}