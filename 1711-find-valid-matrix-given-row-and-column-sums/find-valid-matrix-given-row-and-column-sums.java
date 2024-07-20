class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int n=rowSum.length;
        int m=colSum.length;
        int ans[][]=new int[n][m];
        int i=0;
        int j=0;
        while(i<n && j<m){
            ans[i][j]=Math.min(rowSum[i],colSum[j]);
            rowSum[i]-=ans[i][j];
            colSum[j]-=ans[i][j];
            if(rowSum[i]==0){
                i++;
            }
            if(colSum[j]==0){
                j++;
            }
        }
        return ans;
    }
}