class Solution {
    public int countPaths(int n, int[][] roads) {
        PriorityQueue<long[]>pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        HashMap<Integer,HashMap<Integer,Integer>>adj=new HashMap<>();
        long dist[]=new long[n];
        int ways[]=new int[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        ways[0]=1;
        dist[0]=0;

        //create a graph with its next Node and wt
        for(int i=0;i<n;i++){
            adj.put(i,new HashMap<>());
        }

        for(int i=0;i<roads.length;i++){
            int u=roads[i][0];
            int v=roads[i][1];
            int wt=roads[i][2];
            adj.get(u).put(v,wt);
            adj.get(v).put(u,wt);
        }

        //starting node
        pq.add(new long[]{0,0});


        while(!pq.isEmpty()){
            long curr[]=pq.poll();
            int curr_node=(int)curr[0];
            long curr_wt=curr[1];
            for(Map.Entry<Integer, Integer> entry : adj.get(curr_node).entrySet()){
                int nextNode=entry.getKey();
                int edgeWt = entry.getValue();
                long newDis=curr_wt+edgeWt;

                // new dis is small to previous
                if(newDis<dist[nextNode]){
                    dist[nextNode]=newDis;
                    pq.add(new long[]{nextNode,newDis});
                    ways[nextNode]=ways[curr_node];
                }

                //eqaul distance between from both curr and previous so we can add that both
                else if(newDis==dist[nextNode]){
                    ways[nextNode]=(ways[curr_node]+ ways[nextNode])%((int) 1e9 + 7);
                }
            }
        }
        return ways[n-1]%((int) 1e9 + 7);
    }
}