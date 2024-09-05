class Solution {
    int dp[];
    public int solve(int []arr,int i){
        if(i<0){
            return 0;
        }
        if(i==0){
            return arr[0];
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        return dp[i]=Math.max(solve(arr,i-1),solve(arr,i-2)+arr[i]);
    }
    public int rob(int[] nums) {
        dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return solve(nums,nums.length-1);
    }
}