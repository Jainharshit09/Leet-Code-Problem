class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n= nums.length;
        int sum1=0;
        for(int i=0;i<n;i++){
            sum1+=nums[i];
        }
         if(((sum1-target) % 2 == 1) || (target > sum1))
            return 0;
        int sum=(sum1-target)/2;
        int dp[][]=new int[n+1][sum+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0]=1;
        }
        for(int j=1;j<dp[0].length;j++){
            dp[0][j]=0;
        }
        for(int i=1;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                int v=nums[i-1];
                if(v<=j){
                    dp[i][j]=dp[i-1][j]+dp[i-1][j-v];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}