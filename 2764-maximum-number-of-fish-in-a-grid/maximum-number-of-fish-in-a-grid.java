class Solution {
    int n,m;
    int dirs[][]= {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int bfs(int [][]grid,int i,int j){
        Queue<int[]>q=new LinkedList<>();
        q.add(new int[]{i,j});
        int fish=grid[i][j];
        grid[i][j]=0;
        while(!q.isEmpty()){
            int curr[]=q.poll();
            i=curr[0];
            j=curr[1];
             for (int[] dir : dirs){
                int i_=i+dir[0];
                int j_=j+dir[1];
                if(i_>=0 && j_ >= 0 && i_ < n && j_ < m && grid[i_][j_] > 0){
                    q.add(new int[]{i_,j_});
                    fish+=grid[i_][j_];
                    grid[i_][j_]=0;
                }
             } 
        }
        return fish;
    }
    public int findMaxFish(int[][] grid) {
         n=grid.length;
         m=grid[0].length;
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]>0)
                    ans=Math.max(ans,bfs(grid,i,j));
            }
        }
        return ans;
    }
}