// Find max_or from index i to n-1 using reverse traversal.
// Use sliding window: i = left, j = right, currOr = 0
// Maintain bitCount[32] to track how many times each bit is present in window.
// While j < n and currOr != max_or[i]:
// For each bit b in nums[j]:
// If bit is set, bitCount[b]++, and currOr |= (1 << b)
// Move j++
// When currOr == max_or[i], store ans[i] = j - i
// Before moving i++, remove nums[i]:
// For each bit b in nums[i]:
// If bit is set, bitCount[b]--
// If bitCount[b] == 0, then currOr &= ~(1 << b)
// Repeat till i == n

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
        int[] bitCount = new int[32];
        int currOr = 0;
        int j = 0;
        int i=0;
        while(i<n) {
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
            i++;
        }
        return ans;
    }
}
