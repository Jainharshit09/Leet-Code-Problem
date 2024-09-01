class Solution {
    public int[][] construct2DArray(int[] arr, int m, int n) {
        if(n*m!=arr.length){
            return new int[0][0];
        }
        int[][] ans=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans[i][j]=arr[i*n+j];
            }
        }
        return ans;
    }
}