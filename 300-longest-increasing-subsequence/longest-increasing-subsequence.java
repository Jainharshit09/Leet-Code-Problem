class Solution {
    int dp[][];
    public int solve(int i, int prev,int[] nums){
        int n=nums.length;
        if(i>=n){
            return 0;
        }
        if(prev!=-1&&dp[i][prev]!=-1){
            return dp[i][prev];
        }
        int take=0;
        if(prev==-1 || nums[prev]<nums[i]){
            take=1+solve(i+1,i,nums);
        }
        int skip=solve(i+1,prev,nums);
        if(prev!=-1){
            dp[i][prev]= Math.max(skip,take);
        }
        return  Math.max(skip,take);
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        dp=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return solve(0,-1,nums);
    }
}