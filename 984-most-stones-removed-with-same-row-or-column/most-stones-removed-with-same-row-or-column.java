class Solution {
    public void dfs(int  stones[][],int index,boolean vis[]){
        vis[index]=true;
        for(int i=0;i<stones.length;i++){
            int r=stones[index][0];
            int c=stones[index][1];
            if(!vis[i] && (stones[i][0]==r || stones[i][1]==c)){
                dfs(stones,i,vis);
           }
        }
    }
    public int removeStones(int[][] stones) {
        int n=stones.length;
        boolean vis[]=new boolean[n];
        int group=0;
        for(int i=0;i<n;i++){
            if(vis[i]){
                continue;
            }
                dfs(stones,i,vis);
                group++; 
        }
        return n-group;
    }
}