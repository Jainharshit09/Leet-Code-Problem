class Solution {
    //both node finding the dist 
    public void dfs(int edge[],int dist[],int node,boolean vis[]){
        vis[node]=true;
        int v=edge[node];
        if(v!=-1 && !vis[v]){
            vis[v]=true;
            dist[v]=1+dist[node];
            dfs(edge,dist,v,vis);
        }
    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n=edges.length;
        int dist1[]=new int[n];
        int dist2[]=new int[n];
        Arrays.fill(dist1,Integer.MAX_VALUE); 
        Arrays.fill(dist2,Integer.MAX_VALUE);
        boolean vis1[]=new boolean [n];
        boolean vis2[]=new boolean[n];
        dist1[node1]=0;
        dist2[node2]=0;
        dfs(edges,dist1,node1,vis1);
        dfs(edges,dist2,node2,vis2);
        int minNode=-1;
        int maxValue=Integer.MAX_VALUE;
        //finding common point and min
        for(int i=0;i<n;i++){
            int maxD=Math.max(dist1[i],dist2[i]);
            if(maxValue>maxD){
                maxValue=maxD;
                minNode=i;
            }
        }
        return minNode;
    }
}