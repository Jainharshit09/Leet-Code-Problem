class Solution {
    public void solve(int[][]arr,int n,int m,int ans[][]){
        Queue<int[]>pq=new LinkedList<>();
        for(int l=0;l<n;l++){
            for(int r=0;r<m;r++){
                if(arr[l][r]==1){
                    pq.add(new int[]{l,r});
                    ans[l][r]=0;
                }
                else{
                    ans[l][r]=-1;
                }
            }
        }
            int dirs[][]={{0,1},{1,0},{0,-1},{-1,0}};
            while(!pq.isEmpty()){
                int size=pq.size();
                for(int k=0;k<size;k++){
                    int curr[]=pq.poll();
                    int i=curr[0];
                    int j=curr[1];
                    for(int dir[]:dirs){
                        int i_=i+dir[0];
                        int j_=j+dir[1];
                         if(i_>=0  && i_<n && j_>=0 && j_<m && ans[i_][j_]==-1 ){
                            ans[i_][j_]=ans[i][j]+1;
                            pq.add(new int[]{i_,j_});
                         }
                    }
                }
            }
    }
    public int[][] highestPeak(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int ans[][]=new int[n][m];
        solve(arr,n,m,ans);
        return ans;
    }
}