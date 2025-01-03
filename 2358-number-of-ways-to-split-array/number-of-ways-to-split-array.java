class Solution {
    public int waysToSplitArray(int[] nums) {
        long left=0,right=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            right+=nums[i];
        }
        int count=0;
        for(int i=0;i<n-1;i++){
            left+=nums[i];
            right-=nums[i];
            if(left>=right){
                count++;
            }
        }
        return count;
    }
}