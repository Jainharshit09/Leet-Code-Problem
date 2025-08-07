class Solution {
    public int maxCollectedFruits(int[][] fruits) {
        int n=fruits.length;
        int child1 = 0;
        //for 1st child 
        for (int i = 0; i < n; i++) {
            child1 += fruits[i][i];
        }

        int dp2[][]=new int[n][n];
        for(int i=n-2;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i<j){
                    int maxNext = 0;
                    if (j - 1 >= 0) maxNext = Math.max(maxNext, dp2[i + 1][j - 1]);
                    maxNext = Math.max(maxNext, dp2[i + 1][j]);
                    if (j + 1 < n) maxNext = Math.max(maxNext, dp2[i + 1][j + 1]);
                    dp2[i][j] = fruits[i][j] + maxNext;
                }
            }
        }
        int dp3[][]=new int[n][n];
        for(int j=n-2;j>=0;j--){
            for(int i=0;i<n;i++){
                if(i>j){
                    int maxNext = 0;
                    if (i - 1 >= 0) maxNext = Math.max(maxNext, dp3[i - 1][j + 1]);
                    maxNext = Math.max(maxNext, dp3[i][j + 1]);
                    if (i + 1 < n) maxNext = Math.max(maxNext, dp3[i + 1][j + 1]);
                    dp3[i][j] = fruits[i][j] + maxNext;
                }
            }
        }
        return child1+dp2[0][n-1]+dp3[n-1][0];
    }
}