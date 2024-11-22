class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ans = 0;
        for (int[] currRow : matrix) {
            int count = 0;
            int[] inverted = new int[m];
            for (int i = 0; i < m; i++) {
                inverted[i] = currRow[i] == 0 ? 1 : 0;
            }
            for (int row[] : matrix) {
                if (Arrays.equals(row, currRow) || Arrays.equals(row, inverted)) {
                    count++;
                }
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
}