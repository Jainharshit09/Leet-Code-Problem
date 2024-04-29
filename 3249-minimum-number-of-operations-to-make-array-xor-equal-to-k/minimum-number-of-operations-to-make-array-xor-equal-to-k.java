class Solution {
  public  int minOperations(int[] nums, int k) {
        int xor=0;
        for(int i=0;i<nums.length;i++){
            xor^=nums[i];
        }
        int diff=xor^k;
        return Integer.bitCount(diff);
    }
}