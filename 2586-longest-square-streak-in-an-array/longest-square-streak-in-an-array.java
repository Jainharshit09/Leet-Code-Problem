class Solution {
    public int longestSquareStreak(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int result = 0;
            long val = nums[i];
            while (set.contains((int) val)) {
                result++;
                if(val*val>1e5){
                    break;
                }
                val*=val;
            }
            count = Math.max(count, result);
        }
        return count < 2 ? -1:count;
    }
}