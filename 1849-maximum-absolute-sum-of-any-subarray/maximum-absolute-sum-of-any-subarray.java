class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int sum=0;
        int currSum=0;
        for(int num:nums){
            currSum+=num;
            sum=Math.max(sum,Math.abs(currSum));
            if(currSum<0){
                currSum=0;
            }
        }
        currSum=0;
        for(int num:nums){
            currSum+=num;
            sum=Math.max(sum,Math.abs(currSum));
            if(currSum>0){
                currSum=0;
            }
        }
        return sum;
    }
}