class Solution {
    int n;
    public void dfs(int[][] isConnected,int u,boolean vis[]){
        vis[u]=true;
        for(int v=0;v<n;v++){
            if(!vis[v] && isConnected[u][v]==1){
                dfs(isConnected,v,vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
         n=isConnected.length;
        boolean vis[]=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                count++;
                dfs(isConnected,i,vis);
            }
        }
        return count;
    }
}