class Solution {
    int dp[][];
    public int solve(int i,int j,int [][]grid){
        int n=grid.length;
        int m=grid[0].length;
        if(i==n-1 && j==m-1){
           return grid[i][j] == 1 ? 0 : 1;
        }
        if(i>=n || j>=m){
            return 0;
        }
        if(grid[i][j]==1){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int right=solve(i,j+1,grid);
        int down=solve(i+1,j,grid);
        return dp[i][j]=right+down;
    }
    public int uniquePathsWithObstacles(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        dp=new int [n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }
        return solve(0,0,grid);
    }
}