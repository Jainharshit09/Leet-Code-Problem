class Solution {
   List<int[]> result = new ArrayList<>();
    public void dfs(int[][]land,int i,int j,AtomicInteger r2,AtomicInteger c2){
        int n=land.length;
        int m=land[0].length;
        r2.set(Math.max(i, r2.get()));
        c2.set(Math.max(j, c2.get()));
        if(i<0 || i>=n || j<0 || j>=m || land[i][j]==0){
            return;
        }
        if(land[i][j]==-1){
            return;
        }
        land[i][j]=-1;
        dfs(land,i-1,j,r2,c2);
        dfs(land,i+1,j,r2,c2);
        dfs(land,i,j-1,r2,c2);
        dfs(land,i,j+1,r2,c2);
    }
    public int[][] findFarmland(int[][] land) {
        int n=land.length;
        int m=land[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(land[i][j]==1){
                    int r1=i;
                    int c1=j;
                     AtomicInteger r2 = new AtomicInteger(-1);
                    AtomicInteger c2 = new AtomicInteger(-1);
                    dfs(land,i,j,r2,c2);
                 result.add(new int[]{r1, c1, r2.get()-1, c2.get()-1});
                }
            }
        }
         return result.toArray(new int[result.size()][]);
    }
}