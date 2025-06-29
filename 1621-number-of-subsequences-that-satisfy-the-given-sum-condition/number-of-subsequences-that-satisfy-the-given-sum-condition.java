class Solution {
    int MOD = 1_000_000_007;

    public int binarySearch(int[] nums, int i, int left, int right, int target) {
        int res = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[i] + nums[mid] <= target) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        int count = 0;
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            int j = binarySearch(nums, i, i, n - 1, target);
            if (j >= i) {
                count = (count + powerOfTwo(j - i)) % MOD;
            }
        }

        return count;
    }

    public int powerOfTwo(int exp) {
        long res = 1;
        long base = 2;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return (int) res;
    }
}
