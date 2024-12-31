class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n=days.length;
        int dp[]=new int[days[n-1]+1];
        dp[0]=0;
        int lastday=days[n-1];
        Set<Integer>set=new HashSet<>();
        for(int value:days){
            set.add(value);
        }
        for(int i=1;i<=lastday;i++){
            if(!set.contains(i)){
                dp[i] = dp[i - 1];
                continue;
            }
            dp[i]=Integer.MAX_VALUE;
            int day1=costs[0]+dp[i-1];
            int day7=(i >= 7 ? dp[i - 7] : 0) + costs[1];
            int day30=(i >= 30 ? dp[i - 30] : 0) + costs[2];
            dp[i]=Math.min(day1,Math.min(day7,day30));
        }
        return dp[lastday];
    }
}