class Solution {
    public int solve(int nums[],int index,int currentXOR){
         if (index == nums.length) {
            return currentXOR;
        }
        int take=solve(nums,index+1,currentXOR ^ nums[index]);
        int not_take=solve(nums,index+1,currentXOR);
        return take+not_take;
    }
    public int subsetXORSum(int[] nums) {
        return solve(nums,0,0);
    }
}