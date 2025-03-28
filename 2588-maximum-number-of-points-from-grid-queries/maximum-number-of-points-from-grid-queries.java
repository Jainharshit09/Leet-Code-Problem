class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int Q=queries.length;
        int ans[]=new int[Q];
        int n=grid.length;
        int m=grid[0].length;
        int result=0;
        boolean valid[][]=new boolean[n][m];
       PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
         int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
         int sorted[][]=new int[Q][2];
         for(int i=0;i<Q;i++){
            sorted[i][0]=queries[i];
            sorted[i][1]=i;
         }
        pq.add(new int[]{grid[0][0], 0, 0});
        valid[0][0]=true;
        Arrays.sort(sorted, Comparator.comparingInt(a -> a[0]));
        for(int i=0;i<Q;i++){
            int idx=sorted[i][1];
            int query=sorted[i][0];
            while(!pq.isEmpty() && pq.peek()[0]<query){
                int curr[]=pq.poll();
                int curr_i=curr[1];
                int curr_j=curr[2];
                result++;
                for(int dir[]:directions){
                int new_i=curr_i+dir[0];
                int new_j=curr_j+dir[1];
                if (new_i>=0 && new_i<n && new_j>=0 && new_j<m && !valid[new_i][new_j]){
                    pq.add(new int[]{grid[new_i][new_j],new_i,new_j});
                    valid[new_i][new_j]=true;
                    }
                }
            }
            ans[idx]=result;
        }
        return ans;
    }
}

