class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 1;
        }
        int maxLen = 1;
        int incLen = 1;
        int decLen = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                incLen++;
            } else {
                incLen = 1;
            }
            
            if (nums[i] < nums[i - 1]) {
                decLen++;
            } else {
                decLen = 1;
            }
            maxLen = Math.max(maxLen, Math.max(incLen, decLen));
        }
        
        return maxLen;
    }
}
