class Solution {
    public boolean solve(HashMap<Integer,List<Integer>>adj,boolean vis[],int i){
        int edge=0;
        int vertex=0;
        vis[i]=true;
        Queue<Integer>q=new LinkedList<>();
        q.add(i);
        while(!q.isEmpty()){
            int curr=q.poll();
             vertex++;
            if(adj.containsKey(curr)){
                List<Integer>arr=adj.get(curr);
                edge+=arr.size();
                for (int ngbr : arr) {
                    if (!vis[ngbr]) {
                        vis[ngbr] = true;
                        q.add(ngbr);
                    }
                }
            }
        }
         return (vertex * (vertex- 1)) == edge;
    }
    public int countCompleteComponents(int n, int[][] edges) {
         HashMap<Integer,List<Integer>>adj=new HashMap<>();
         for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for(int edge[]:edges){
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int ans=0;
        boolean vis[]=new boolean[n];
        for(int i=0;i<n;i++){
            if(vis[i]!=true){
                if(solve(adj,vis,i)){
                    ans++;
                }
            }
        }
        return ans;
    }
}