class Solution {
    int n;
    private final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int dfs(int grid[][],int i,int j,int id){
         if (i < 0 || i >= n || j < 0 || j >= n || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j]=id;
        int count=1;
        for(int [] dir:directions){
            int x=i+dir[0];
            int y=j+dir[1];
            count += dfs(grid, x, y, id);
        }
        return count;
    }
    public int largestIsland(int[][] grid) {
        n=grid.length;
        HashMap<Integer,Integer>map=new HashMap<>();
        int islandId=2;
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                     int size = dfs(grid, i, j, islandId);
                     ans=Math.max(ans,size);
                     map.put(islandId,size);
                     islandId++;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    Set<Integer>list=new HashSet<>();
                    for (int[] dir : directions){
                        int x=i+dir[0];
                        int y=j+dir[1];
                         if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] != 0){
                            list.add(grid[x][y]);
                        }
                    }
                    int sum=1;
                    for(int id:list){
                        sum+=map.get(id);
                    }
                    ans=Math.max(ans,sum);
                }
            }
        }
        return ans;
    }
}