//need to find the stricitly increasing
// so we can go increasing find up,down,left,right
//we can solve using dfs 
// basic like normal dfs question simulation problem

class Solution {
    int direction[][]={{0,1},{1,0},{-1,0},{0,-1}};
    int dp[][];
    int n ,m;
    public int dfs(int i,int j,int grid[][]){
        if(i<0 || j<0 || i >= n || j >= m)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int longest_path=0;
        for(int dir[]:direction){
            int x=i+dir[0];
            int y=j+dir[1];
            if(x>=0 && y>=0 &&  x<n &&  y<m && grid[i][j]<grid[x][y]){
                longest_path=Math.max(dfs(x,y,grid),longest_path);
            }
        }
        return dp[i][j]=longest_path+1;
    }
    public int longestIncreasingPath(int[][] matrix) {
         n=matrix.length;
         m=matrix[0].length;
        dp=new int[n][m];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int path=dfs(i,j,matrix);
                ans=Math.max(ans,path);
            }
        }
        return ans;
    }
}