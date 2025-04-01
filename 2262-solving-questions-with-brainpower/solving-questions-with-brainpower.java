class Solution {
    long dp[];
    int n;
    public long solve(int[][] arr,int i){
        if(i>=n){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        long take=solve(arr,i+arr[i][1]+1)+arr[i][0];
        long not_take=solve(arr,i+1);
        return dp[i]=Math.max(take,not_take);
    }
    public long mostPoints(int[][] questions) {
        n=questions.length;
        dp=new long[n+1];
        Arrays.fill(dp,-1);
         return solve(questions,0);
    }
}