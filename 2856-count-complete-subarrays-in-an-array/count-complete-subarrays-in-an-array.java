class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int k = 0; k < n; k++) {
            set.add(nums[k]);
        }

        int i = 0;
        int j = 0;
        int ans = 0;

        while (i < n) {
            while (j < n && map.size() < set.size()) {
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
                j++;
            }
            if (map.size() == set.size()) {
                ans += n - j + 1;
            }
            map.put(nums[i], map.get(nums[i]) - 1);
            if (map.get(nums[i]) == 0) {
                map.remove(nums[i]);
            }
            i++;
        }

        return ans;
    }
}
