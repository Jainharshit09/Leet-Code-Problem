class Solution {
    int n;
    int parent[];
    int rank[];
    public int find(int i){
        if(parent[i]!=i){
            parent[i]=find(parent[i]);
        }
        return parent[i];
    }
    public void union(int i,int j){
        int rooti=find(i);
        int rootj=find(j);
        if(rooti!=rootj){
            if(rank[rooti]>rank[rootj]){
                parent[rootj]=rooti;
            }
            else if(rank[rootj]>rank[rooti]){
                parent[rooti]=rootj;
            }
            else{
                parent[rootj]=parent[rooti];
                rank[rooti]++;
            }
        }
    }
    public int removeStones(int[][] stones) {
         n=stones.length;
        parent=new int[n];
        rank=new int [n];
        int group=0;
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=i;
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(stones[i][0]==stones[j][0] || stones[i][1]==stones[j][1]){
                    union(i,j);
                }
            }
        }
        for(int i=0;i<n;i++){
            if(parent[i]==i){
                group++;
            }
        }
        return n-group;
    }
}