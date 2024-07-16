class Solution {
    public int maxProfit(int[] prices) {
        int ans=0;
        int buy=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            if(buy<prices[i]){
                ans+=prices[i]-buy;
                buy=prices[i];
            }
            else{
                buy=prices[i];
            }
        }
        return ans;
    }
}