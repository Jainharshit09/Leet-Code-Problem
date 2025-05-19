class Solution {
    public String triangleType(int[] nums) {
        int n=nums.length;
        boolean valid=(nums[0]+nums[1]>nums[2] &&
                        nums[1]+nums[2]>nums[0] &&
                        nums[0]+nums[2]>nums[1]
                      );
        if(!valid){
            return "none";
        }
        if(nums[0]==nums[1] && nums[1]==nums[2]){
            return "equilateral";
        }
        if(nums[0] != nums[1] && nums[0] != nums[2] && nums[1] != nums[2]){
            return "scalene";
        }
        return "isosceles";
    }
}