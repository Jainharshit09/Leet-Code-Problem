class Solution {
    public boolean solve(int []arr,int n,int sum){
         boolean dp[][]=new boolean[n+1][sum+1];
         for(int i=0;i<=n;i++){
            dp[i][0]=true;
         }
         for(int j=1;j<=sum;j++){
            dp[0][j]=false;
         }
         for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                int v=arr[i-1];
                if(v<=j && dp[i-1][j-v]==true){
                    dp[i][j]=true;
                }
                else if(dp[i-1][j]==true){
                        dp[i][j]=true;
                }
            }
         }
         return dp[n][sum];
    }
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        sum=sum/2;
        return solve(nums,n,sum);
    }
}