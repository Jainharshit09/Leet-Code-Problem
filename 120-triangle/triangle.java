class Solution {
    int dp[][]=new int [200][200];
    public int solve(int i,int j,List<List<Integer>> triangle){
        int n=triangle.size();
        if(i>=n||j>=n) return Integer.MAX_VALUE;
        if(i==n-1){
            return triangle.get(i).get(j);
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int down=solve(i+1,j,triangle);
        int diagonal=solve(i+1,j+1,triangle);
        return dp[i][j]= triangle.get(i).get(j)+Math.min(down,diagonal);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i=0;i<200;i++){
            for(int j=0;j<200;j++){
                dp[i][j]=-1;
            }
        }
        return solve(0,0,triangle);
    }
}