class Solution {
    public int maxProfit(int[] price) {
        int n=price.length;
       int dp[]=new int[n];
       dp[0]=0;
       int buy=price[0];
       for(int i=1;i<n;i++){
        dp[i]=Math.max(dp[i-1],price[i]-buy);
        buy=Math.min(price[i],buy);
       }
       return dp[n-1];
    }
}