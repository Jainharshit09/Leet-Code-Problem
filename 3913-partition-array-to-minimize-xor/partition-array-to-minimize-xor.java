//standard sp problem
class Solution {
    public int minXor(int[] nums, int k) {
        int n=nums.length;
        int dp[][]=new int[n+1][k+1];
        for(int i=0;i<=n;i++){
           for(int j=0;j<=k;j++){
            dp[i][j]=Integer.MAX_VALUE;
            }
        }
        dp[0][0]=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=k;j++){
                int currXor=0;
                for(int p=i-1;p>=0;p--){
                    currXor^=nums[p];
                    dp[i][j]=Math.min(dp[i][j],Math.max(dp[p][j-1],currXor));
                }
            }
        }
         return dp[n][k];
    }
}