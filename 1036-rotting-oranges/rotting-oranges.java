class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        if(grid==null || n==0){
            return 0;
        }
        int count_fresh=0;
        Queue<int[]>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
                if(grid[i][j]!=0){
                    count_fresh++;
                }
            }
        }
        if(count_fresh==0){
            return 0;
        }
        int min=0;
        int cnt=0;
        int dx[]={0,0,1,-1};
        int dy[]={1,-1,0,0};
        while(!q.isEmpty()){
            int size=q.size();
            cnt+=size;
            for(int i=0;i<size;i++){
                int points[]=q.poll();
                for(int j=0;j<4;j++){
                    int x=points[0]+dx[j];
                    int y=points[1]+dy[j];
                    if(x<0||y<0||x>=n||y>=m||grid[x][y]==0||grid[x][y]==2)continue;
                    grid[x][y]=2;
                    q.add(new int[]{x,y});

                }
            }
            if(q.size()!=0){
                min++;
            }
        }
        return count_fresh==cnt?min:-1;
    }
}