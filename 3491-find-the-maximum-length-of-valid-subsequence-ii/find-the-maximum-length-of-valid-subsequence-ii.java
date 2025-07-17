class Solution {
    public int maximumLength(int[] nums, int k) {
        int n=nums.length;
        int ans=1;
        int dp[][]= new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                dp[i][j] = 1;
            }
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                int mod=(nums[i]+nums[j])%k;
                dp[i][mod]=Math.max(dp[i][mod],dp[j][mod]+1);
                ans=Math.max(ans,dp[i][mod]);
            }
        }
        return ans;
    }
}