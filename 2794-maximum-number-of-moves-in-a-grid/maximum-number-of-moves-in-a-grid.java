class Solution {
    int dp[][];
    public int solve(int i,int j,int grid[][]){
        int n=grid.length;
        int m=grid[0].length;
        if(i>=n||i<0 || j>=m||j<0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int result=0;
         if (i+1<n && j+1<m && grid[i+1][j+1]>grid[i][j]){
            int diagonal=1+solve(i+1,j+1,grid);
            result=Math.max(result,diagonal);
         }
         if (i-1>=0 && j+1<m && grid[i-1][j+1]>grid[i][j]){
            int reverse=1+solve(i-1,j+1,grid);
            result=Math.max(result,reverse);
         }
         if (j+1<m && grid[i][j+1]>grid[i][j]){
            int right=1+solve(i,j+1,grid);
             result=Math.max(result,right);
         }
        return dp[i][j]= result;
    }
    public int maxMoves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        dp=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans=Math.max(solve(i,0,grid),ans);
        }  
        return ans;    
    }
}