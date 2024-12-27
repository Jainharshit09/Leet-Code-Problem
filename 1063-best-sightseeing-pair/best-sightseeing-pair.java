class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n=values.length;
        int dp[]=new int[n];
        int ans=Integer.MIN_VALUE;
        dp[0]=values[0];
        for(int i=1;i<n;i++){
            dp[i]=Math.max(dp[i-1],values[i]+i);
            int curr=values[i]-i;
            ans=Math.max(dp[i-1]+curr,ans);
        }
        return ans;
    }
}