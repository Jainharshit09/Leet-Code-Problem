class Solution {
    public int find(int parent[],int x){
        if(parent[x]!=x){
            parent[x]=find(parent,parent[x]);
        }
        return parent[x];
    }
    public void union(int parent[],int rank[],int x,int y){
          int rootX = find(parent,x);
            int rootY = find(parent,y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
    }
    public int makeConnected(int n, int[][] connections) {
        int m=connections.length;
        if(n-1>m){
            return -1;
        }
        int ans=0;
        int parent[]=new int[n];
        int rank[]=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
             rank[i] = 0;
        }
        for(int connection[]:connections){
           int rootX = find(parent, connection[0]);
           int rootY = find(parent, connection[1]);
           if (rootX != rootY) {
                union(parent, rank, connection[0], connection[1]);
            } else {
                ans++;
            }
        }
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                components++;
            }
        }
        return components - 1 <= ans ? components - 1 : -1;
    }
}
// ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        // for(int i=0;i<m;i++){
        //     adj.add(new ArrayList<>());
        // }
        // for(int [] list:connections){
        //     int u=list[0];
        //     int v=list[1];
        //     adg.get(u).add(v);
        //     adj.get(v).add(u);
        // }