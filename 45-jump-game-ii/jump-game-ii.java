class Solution {
    int dp[];
    public int solve(int nums[],int n,int idx){
        if(idx>=n-1){return 0;}
        if(dp[idx]!=Integer.MAX_VALUE){
            return dp[idx];
        }
        for(int i=1;i<=nums[idx];i++){
          if(idx+i<n){
            int jump=solve(nums,n,idx+i);
             if(jump!=Integer.MAX_VALUE){
                dp[idx]=Math.min(dp[idx],1+jump);
             }
          }
        }
        return dp[idx];
    }
    public int jump(int[] nums) {
        int n=nums.length;
        dp=new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        return solve(nums,n,0);
    }
}