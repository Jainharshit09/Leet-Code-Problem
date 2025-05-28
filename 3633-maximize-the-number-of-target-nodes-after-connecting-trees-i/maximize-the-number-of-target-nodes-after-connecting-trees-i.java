class Solution {
    // public int dfs(int curr,Map<Integer,List<Integer>>adj,int k,int parent){
    //     if(k<0){
    //         return 0;
    //     }
    //     int count=1;  // make it 1 beacuse we adding in answer also curr
    //     for(int ngbr: adj.getOrDefault(curr, new ArrayList<>())){
    //         if(ngbr!=parent){
    //             count+=dfs(ngbr,adj,k-1,curr);
    //         }
    //     }
    //     return count;
    // }


    public int bfs(int curr,Map<Integer,List<Integer>>adj,int k,int n){
        int count=0;
        Queue<int[]>q=new LinkedList<>();
        boolean vis[]=new boolean [n];
        vis[curr]=true;
        q.add(new int[]{curr,0});
        while(!q.isEmpty()){
            int[] pair = q.poll();
            int currNode = pair[0];
            int dist = pair[1];
            if(dist>k){
                continue;
            }
            count++;
            for(int ngbr:adj.getOrDefault(currNode, new ArrayList<>())){
                if(!vis[ngbr]){
                    vis[ngbr]=true;
                    q.add(new int[]{ngbr,dist+1});
                }
            }
        }

        return count;
    }
    public int[] findCount(int[][]edges,int d){
        int n=edges.length+1;
        Map<Integer,List<Integer>>adj=new HashMap<>();
         for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        int result[]=new int[n];
        for(int i=0;i<n;i++){ result[i]=bfs(i,adj,d,n);}
        return result;
        
    }
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int result[]=findCount(edges1,k);
        int ans[]=findCount(edges2,k-1);
        int max=0;
        for(int i=0;i<ans.length;i++){max=Math.max(max,ans[i]);}
        for(int i=0;i<result.length;i++){result[i]+=max;}
        return result;
    }
}