class Solution {
    public int minimumIndex(List<Integer> nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.size(); i++) {
            map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
        }

        HashMap<Integer, Integer> check = new HashMap<>();
        for(int i = 0; i < nums.size(); i++) {
            check.put(nums.get(i), check.getOrDefault(nums.get(i), 0) + 1);
            map.put(nums.get(i), map.get(nums.get(i)) - 1);

            int n = i + 1;
            int m = nums.size() - n;

            if (check.get(nums.get(i)) > n / 2 && map.get(nums.get(i)) > m / 2) {
                return i;
            }
        }

        return -1;
    }
}
