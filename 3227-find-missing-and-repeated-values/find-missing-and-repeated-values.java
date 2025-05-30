class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length;
        int N=n*n;
        long gridSum=0;
        long gridSqSum=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                gridSum+=grid[i][j];
                gridSqSum+=grid[i][j]*grid[i][j];
            }
        }
        long sum = (long) N * (N + 1) / 2;
        long SqSum = (long) N * (N + 1) * (2 * N + 1) / 6;
        long sqdiff=gridSqSum-SqSum;
        long sumdiff=gridSum-sum;
        int a=(int)((sqdiff/sumdiff)+sumdiff)/2;
        int b=(int)((sqdiff/sumdiff)-sumdiff)/2;
        return new int[]{a,b};
    }
}