class Solution {
    // create a graph
    // traverse the dfs
    //find max depth 
    //max depht having same edges having 2 way 1 oe 2 select odd way means 2^d/2 give me odd ways
    int MOD=1000000007;
    public void dfs(int curr, HashMap<Integer,List<Integer>>adj,int parent,int depth,int maxDepth[]){
        maxDepth[0]=Math.max(depth,maxDepth[0]);
        for(int ngbr:adj.getOrDefault(curr,new ArrayList<>())){
            if(parent!=ngbr){
                dfs(ngbr,adj,curr,depth+1,maxDepth);
            }
        }
    }
    public int assignEdgeWeights(int[][] edges) {
        HashMap<Integer,List<Integer>>adj=new HashMap<>();
        int n=edges.length+1;
        for(int i=1;i<=n;i++){
            adj.put(i,new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int maxDepth[]=new int[1];
        maxDepth[0]=0;
        dfs(1,adj,-1,0,maxDepth);

        // rather than calling in maxdepth we can use binary exponatation also there it will solve in log n
        int result=1;
        for(int i=1;i<maxDepth[0];i++){
            result=(result*2)%MOD;
        }
        return result;
    }
}