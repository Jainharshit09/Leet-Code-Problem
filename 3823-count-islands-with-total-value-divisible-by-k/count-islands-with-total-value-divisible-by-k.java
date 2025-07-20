class Solution {
    public int dfs(int x,int y,boolean vis[][],int grid[][],int n,int m){
        if(x>=n || x<0 || y>=m ||y<0 || vis[x][y] || grid[x][y]==0)return 0;
        vis[x][y]=true;
        int total=grid[x][y];
        total+=dfs(x-1,y,vis,grid,n,m);
        total+=dfs(x+1,y,vis,grid,n,m);
        total+=dfs(x,y-1,vis,grid,n,m);
        total+=dfs(x,y+1,vis,grid,n,m);
        return total;
    }
    public int countIslands(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        boolean vis[][]=new boolean[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j] || grid[i][j]==0)continue;
                int sum=dfs(i,j,vis,grid,n,m);
                if(sum%k==0)count++;
            }
        }
        return count;
    }
}