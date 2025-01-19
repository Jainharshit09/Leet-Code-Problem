class Solution {
    public int trapRainWater(int[][] map) {
        int m=map.length;
        int n=map[0].length;
        PriorityQueue<int[]>pq=new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        boolean vis[][]=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0 || i==m-1 || j==n-1) {
                    pq.add(new int[]{map[i][j],i,j});
                    vis[i][j]=true;
                }
            }
        }
         int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
         int water=0;
        while(!pq.isEmpty()){
            int curr[]=pq.poll();
            int height=curr[0];
            int i=curr[1];
            int j=curr[2];
            for(int dir[]:directions){
                int i_=i+dir[0];
                int j_=j+dir[1];
                if (i_ >= 0 && i_ < m && j_ >= 0 && j_ < n && !vis[i_][j_]){
                    water+=Math.max(height-map[i_][j_],0);
                    pq.add(new int[]{Math.max(height,map[i_][j_]),i_,j_});
                    vis[i_][j_]=true;
                }
            }
        }
        return water;
    }
}