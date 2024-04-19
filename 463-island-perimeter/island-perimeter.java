class Solution {
    int perimeter;
    public void dfs(int grid[][],int i,int j){
        int n= grid.length;
        int m=grid[0].length;
        if(i<0||i>=n||j<0||j>=m||grid[i][j]==0){
            perimeter++; 
            return; 
        }
        if(grid[i][j]== -1){
             return;
        }
        grid[i][j]=-1;
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
    public int islandPerimeter(int[][] grid) {
        int n= grid.length;
        int m=grid[0].length;
        perimeter=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    dfs(grid,i,j);
                     return perimeter;
                }
            }
        }
       return 0;
    }
}