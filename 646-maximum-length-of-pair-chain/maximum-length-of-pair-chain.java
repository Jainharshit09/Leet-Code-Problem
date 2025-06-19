//similar question like lis Longest Increasing Subsequence in which only change is that we need to arrange in any order for that we used sort on basis of 2 index

class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
        int n=pairs.length;
        int dp[]=new int[n];
        Arrays.fill(dp,1);
        int maxL=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(pairs[j][1] < pairs[i][0]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                     maxL =Math.max(maxL, dp[i]);
                }
            }
        }
        return maxL;
    }
}