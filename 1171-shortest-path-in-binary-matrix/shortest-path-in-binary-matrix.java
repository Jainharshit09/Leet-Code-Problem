// using bfs
// class Pair{
//     int dist;
//     int x;
//     int y;
//     public Pair(int x,int y,int dist){
//         this.dist=dist;
//         this.x=x;
//         this.y=y;
//     }
// }
// class Solution {
//     public int shortestPathBinaryMatrix(int[][] grid) {
//         int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
//         int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
//         int n=grid.length;
//         int m=grid[0].length;
//         if(m==0 ||n==0 || grid[0][0]!=0)
//         {
//             return -1;
//         }
//         Queue<Pair> q=new LinkedList<>();
//         q.add(new Pair(0,0,0));
//         grid[0][0]=1;
//         int level=0;
//         while(!q.isEmpty()){
//             int N=q.size();
//             while(N-->0){
//                 Pair curr=q.poll();
//                 int X=curr.x;
//                 int Y=curr.y;
//                 int dist=curr.dist;
//                 if(X==n-1 && Y==m-1){
//                     return level+1;
//                 }
//                 for(int i=0;i<8;i++){

//                     int new_x=dx[i]+X;
//                     int new_y=dy[i]+Y;
//                     if(new_x>=0 && new_y>=0 && new_x<n && new_y<m && grid[new_x][new_y]==0){
//                         q.add(new Pair(new_x,new_y,dist + 1));
//                         grid[new_x][new_y] = 1;

//                     }
//                 }
//             }
//             level++;
//         }
//         return -1;
//     }
// }




// using dijkstra
class Pair implements Comparable<Pair>{
    int x,y,dt;
    public Pair(int x,int y,int dt){
        this.x=x;
        this.y=y;
        this.dt=dt;
    }
    public int compareTo(Pair p){
        return this.dt-p.dt;
    }
}
class Solution{
    public int shortestPathBinaryMatrix(int[][] grid) {
        int dx[]={-1, -1, -1, 0, 0, 1, 1, 1};
        int dy[]={-1, 0, 1, -1, 1, -1, 0, 1};
        int n=grid.length;
        int m=grid[0].length;
        boolean vis[][]=new boolean[n][m];
       if (grid[0][0] != 0 || grid[n-1][m-1] != 0) {
            return -1;
        }
        int dist[][]=new int[n][m];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0,1));
        dist[0][0]=1;
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int X=curr.x;
            int Y=curr.y;
            int dt=curr.dt;
            if(X==n-1 && Y==m-1){
                return dist[n-1][m-1];
            }
            for(int i=0;i<8;i++){
                int new_x=X+dx[i];
                int new_y=Y+dy[i];
                if (new_x>= 0 && new_y >= 0 && new_x < n && new_y < m && grid[new_x][new_y] == 0 && !vis[new_x][new_y]){
                     pq.add(new Pair(new_x, new_y, dt + 1));
                     vis[new_x][new_y]=true;
                     dist[new_x][new_y] = dt + 1;
                }
            }
        }
         return -1;
    }
}