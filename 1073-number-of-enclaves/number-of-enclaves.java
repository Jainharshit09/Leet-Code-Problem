class Solution {
    int n,m;
    boolean vis[][];
    int direction[][]={{0,1},{1,0},{0,-1},{-1,0}};
    public void dfs(int i,int j,int grid[][]){
        vis[i][j]=true;
        for(int []dir : direction){
            int new_i=i+dir[0];
            int new_j=j+dir[1];
            if(new_i>=0 &&  new_i<n && new_j>=0 && new_j<m &&!vis[new_i][new_j]&& grid[new_i][new_j]==1){
                dfs(new_i,new_j,grid);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int result=0;
        n=grid.length;
        m=grid[0].length;
        vis=new boolean[n][m];
        for(int j=0;j<m;j++){
            if(grid[0][j]==1 && !vis[0][j]){
                dfs(0,j,grid);
            }
            if(grid[n-1][j]==1 && !vis[n-1][j]){
                dfs(n-1,j,grid);
            }
        }
        for(int i=0;i<n;i++){
                if(grid[i][0]==1 && !vis[i][0]){
                dfs(i,0,grid);
            }
            if(grid[i][m-1]==1 && !vis[i][m-1]){
                dfs(i,m-1,grid);
            } 
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && !vis[i][j]){
                    result++;
                }
            }
        }
        return result;
    }
}