class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        if (nums.length < k) {
            return 0;
        }
        long ans = 0;
        int i = 0;
        int j = 0;
        long sum = 0;
        int n = nums.length;
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        while (j < n) {
            sum += nums[j];
            freqMap.put(nums[j], freqMap.getOrDefault(nums[j], 0) + 1);
            while (freqMap.get(nums[j]) > 1) {
                sum -= nums[i];
                freqMap.put(nums[i], freqMap.get(nums[i]) - 1);
                if (freqMap.get(nums[i]) == 0) {
                    freqMap.remove(nums[i]);
                }
                i++;
            }
            if (j - i + 1 == k) {
                ans = Math.max(ans, sum);
                sum -= nums[i];
                freqMap.put(nums[i], freqMap.get(nums[i]) - 1);
                if (freqMap.get(nums[i]) == 0) {
                    freqMap.remove(nums[i]);
                }
                i++;
            }

            j++;
        }
        return ans;
    }
}