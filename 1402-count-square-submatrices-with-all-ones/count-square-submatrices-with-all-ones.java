class Solution {
    public int countSquares(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int [][] dp=new int[n][m];
        int result=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0){
                    dp[i][j]=arr[i][j];
                }
                else{
                    if (arr[i][j] == 1) {
                     dp[i][j]=1+Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j -1]);
                    }
                }
                result+=dp[i][j];
            }
        }
        return result;
    }
}