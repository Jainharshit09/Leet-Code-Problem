class pair implements Comparable<pair>{
    int v;
    int wt;
    public pair(int v,int wt){
       this.v=v;
       this.wt=wt;
    }
    public int compareTo(pair p){
      return this.wt-p.wt;}
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int ans[]=new int [n+1];
        boolean vis[]=new boolean[n+1];
        PriorityQueue<pair> pq=new PriorityQueue<>();
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[k]=0;
        pq.add(new pair(k,0));
        while(!pq.isEmpty()){
        pair curr= pq.remove();
        int v= curr.v;
        if(vis[v]){
           continue;
        }
        vis[v]=true;
        for(int [] time:times){
          if(time[0]==v){
           int vertex=time[1];
           int weight=time[2];
           if(ans[vertex]>ans[v]+weight){
              ans[vertex]=ans[v]+weight;
              pq.add(new pair(vertex,ans[vertex]));
               }
             }
           }
        }
        int result=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            result=Math.max(result,ans[i]);
        }
        if(result==Integer.MAX_VALUE){
            return -1;
        }
        return result;
    }
}