// it is a type of coin change 2 
// in that we need to find count
// in already give count
// we need to find the coin
// this is type of reverse dp question
//to solve that if dp[amount]==target-1 than possible that from all previous will create me and now i need to add me so make equal to target the target in numWays-1
class Solution {
    public List<Integer> findCoins(int[] numWays) {
        int n=numWays.length;
        int dp[]=new int[n+1];
        // it because not taking any coin 
        dp[0]=1;
         List<Integer> coins=new ArrayList<>();
         for(int i=0;i<n;i++){
            int amount=i+1;
            int target=numWays[i];
            // imporatant part to check from previous all this amount is create or not
            if(dp[amount]==target-1){
                coins.add(amount);
                //similar coin change 2 logic
                for(int coin=amount;coin<=n;coin++){
                    dp[coin]+=dp[coin-amount];
                }
            }
            if(dp[amount]!=target){
                return new ArrayList<>();
            }
         }
         return coins;
    }
}