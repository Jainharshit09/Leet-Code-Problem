class Solution {
    private int countSteps(int ringIndex, int i, int n) {
        int anticlockwise = Math.abs(i - ringIndex);
        int clockwise = n - anticlockwise;
        return Math.min(clockwise, anticlockwise);
    }

    public int findRotateSteps(String ring, String key) {
        int[][] dp = new int[ring.length()][key.length() + 1];

        // Initialize the base case
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        for (int ringIndex = 0; ringIndex < ring.length(); ringIndex++) {
            dp[ringIndex][key.length()] = 0;
        }

        for (int keyIndex = key.length() - 1; keyIndex >= 0; keyIndex--) {
            for (int ringIndex = 0; ringIndex < ring.length(); ringIndex++) {
                int result = Integer.MAX_VALUE;
                char keyChar = key.charAt(keyIndex);
                for (int i = 0; i < ring.length(); i++) {
                    if (ring.charAt(i) == keyChar) {
                        int totalSteps = countSteps(ringIndex, i, ring.length()) + 1 + dp[i][keyIndex + 1];
                        result = Math.min(result, totalSteps);
                    }
                }
                dp[ringIndex][keyIndex] = result;
            }
        }
        return dp[0][0];
    }
}
