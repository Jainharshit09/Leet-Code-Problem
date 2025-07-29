class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] maxOr = new int[n];
        // Step 1: Precompute maxOr from right to left
        int or = 0;
        for (int i = n - 1; i >= 0; i--) {
            or |= nums[i];
            maxOr[i] = or;
        }

        int[] bitCount = new int[32];  // To track each bit's frequency in window
        int currOr = 0;
        int j = 0;

        for (int i = 0; i < n; i++) {

            // Move j forward until currOr == maxOr[i]
            while (j < n && currOr != maxOr[i]) {
                int val = nums[j];
                for (int b = 0; b < 32; b++) {
                    if (((val >> b) & 1) == 1) {
                        bitCount[b]++;
                        currOr |= (1 << b);
                    }
                }
                j++;
            }

              ans[i] = Math.max(1, j - i);

            // Remove nums[i]'s bits from currOr
            int val = nums[i];
            for (int b = 0; b < 32; b++) {
                if (((val >> b) & 1) == 1) {
                    bitCount[b]--;
                    if (bitCount[b] == 0) {
                        currOr &= ~(1 << b); // clear bit b
                    }
                }
            }
        }

        return ans;
    }
}
