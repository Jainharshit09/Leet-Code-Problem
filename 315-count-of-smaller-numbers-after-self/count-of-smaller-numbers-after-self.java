class Solution {
    int[] bit;
    int offset;

    public void update(int index, int val) {
        for (int i = index; i < bit.length; i += (i & -i)) {
            bit[i] += val;
        }
    }

    public int sum(int index) {
        int sum = 0;
        for (int i = index; i > 0; i -= (i & -i)) {
            sum += bit[i];
        }
        return sum;
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        
        offset = -min;
        int size = max - min + 1;
        
        bit = new int[size + 1];
        
        List<Integer> result = new ArrayList<>();
        
        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i] + offset;
            result.add(0, sum(num));
            update(num + 1, 1);
        }
        
        return result;
    }
}
