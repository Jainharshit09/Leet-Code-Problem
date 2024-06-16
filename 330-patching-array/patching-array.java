class Solution {
    public int minPatches(int[] nums, int n) {
        int i=0;
        int path=0;
        long maxreach=0;
        while(maxreach<n){
            if(i<nums.length && nums[i]<=maxreach+1){
                maxreach+=nums[i];
                i++;
            }
            else{
                maxreach+=maxreach+1;
                path++;
            }
        }
        return path;
    }
}