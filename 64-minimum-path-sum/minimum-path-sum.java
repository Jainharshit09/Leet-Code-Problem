class Solution {
    int dp[][];
    public int solve(int i,int j,int grid[][]){
        int n=grid.length;
        int m=grid[0].length;
        if(i>=n || j>=m){
           return Integer.MAX_VALUE; 
        }
        if(i==n-1 && j==m-1){
            return grid[i][j];
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        return dp[i][j]=grid[i][j]+Math.min(solve(i+1,j,grid),solve(i,j+1,grid));
    }
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        dp=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }
        return solve(0,0,grid);
    }
}