// this simple question like Min spanning tree
// from every point we go in min time
// so first create a adj list because write we need to try all possible answer but current only point is given
class Solution {
    public int minCostConnectPoints(int[][] points) {
        Map<Integer,List<int[]>>adj=new HashMap<>();
        int n=points.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                int val=Math.abs(x1-x2)+Math.abs(y1-y2);
                adj.putIfAbsent(j,new ArrayList<>());
                adj.putIfAbsent(i,new ArrayList<>());
                adj.get(i).add(new int[]{j,val});
                adj.get(j).add(new int[]{i,val});
            }
        }
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b) -> a[1]-b[1]);
        boolean vis[]=new boolean[n];
        int ans=0;
        pq.add(new int[]{0,0});
        while(!pq.isEmpty()){
            int curr[]=pq.poll();
            int u=curr[0];
            int cost=curr[1];
            if(vis[u])continue;
            vis[u]=true;
            ans+=cost;
            for(int ngbr[]:adj.getOrDefault(u,new ArrayList<>())){
                int v=ngbr[0];
                int wt=ngbr[1];
                if(vis[v])continue;
                pq.add(new int[]{v,wt});
            }
        }
        return ans;
    }
}