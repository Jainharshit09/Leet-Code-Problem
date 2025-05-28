class Solution {
    public int dfs(int curr,Map<Integer,List<Integer>>adj,int k,int parent){
        if(k<0){
            return 0;
        }
        int count=1;  // make it 1 beacuse we adding in answer also curr
        for(int ngbr: adj.getOrDefault(curr, new ArrayList<>())){
            if(ngbr!=parent){
                count+=dfs(ngbr,adj,k-1,curr);
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
        for(int i=0;i<n;i++){ result[i]=dfs(i,adj,d,-1);}
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