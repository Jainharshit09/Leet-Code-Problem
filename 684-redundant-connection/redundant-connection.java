class DSU{
    int parent[];
    int rank[];
    public DSU(int n){
        parent=new int[n+1];
        rank=new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i]=i;
            rank[i]=0;
        }
    }
    public int find(int x){
        if(parent[x]==x){
            return x;
        }
        return parent[x]=find(parent[x]);
    }
    public void union(int x,int y){
        int xParent=find(x);
        int yParent=find(y);
        if(xParent==yParent){
            return;
        }
        if (rank[xParent] > rank[yParent]) {
            parent[yParent] = xParent;
        }
        else if(rank[xParent] < rank[yParent]){
            parent[xParent] = yParent;
        }
        else{
            parent[yParent] = xParent;
            rank[xParent]++;
        }
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        DSU dsu=new DSU(n);
        for(int edge[]:edges){
            int u=edge[0];
            int v=edge[1];
            if(dsu.find(u)==dsu.find(v)){
                return edge;
            }
            dsu.union(u,v);
        }
        return new int[0];
    }
}