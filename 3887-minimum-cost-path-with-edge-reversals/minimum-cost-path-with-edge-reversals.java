class Solution {

    public long[] dijkstra(int src,Map<Integer,List<int[]>>graph,int n){
        long ans[]=new long[n];
        Arrays.fill(ans,Long.MAX_VALUE);
        ans[src]=0;
        PriorityQueue<long[]>pq=new PriorityQueue<>((p1, p2) -> 
            p1[0] == p2[0] ? Long.compare(p1[1], p2[1]) : Long.compare(p1[0], p2[0]));
        pq.add(new long[]{src,0});
        while(!pq.isEmpty()){
            long curr[]=pq.poll();
            int u=(int) curr[0];
            long dist=curr[1];
            if(dist>ans[u])continue;
            for(int ngbr[]:graph.get(u)){
                int v=ngbr[0];
                int w=ngbr[1];
                if(ans[v]>dist+w){
                    ans[v]=dist+w;
                    pq.add(new long[]{v,dist+w});
                }
            }
        }
        return ans;
    }
    
    public int minCost(int n, int[][] edges) {
        Map<Integer,List<int[]>>adj=new HashMap<>();
        for(int i=0;i<n;i++){
            adj.put(i,new ArrayList<>());
        }
        for(int e[]:edges){
            int u=e[0];
            int v=e[1];
            int w=e[2];
            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,2*w});
        }

        long dist1[]=dijkstra(0,adj,n);
        long ans=dist1[n-1];
        return ans==Long.MAX_VALUE ? -1 : (int)ans;
    }
}