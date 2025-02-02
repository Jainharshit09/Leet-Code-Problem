class Solution {
    public boolean check(int[] nums) {
        int rotate=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]>nums[(i+1)%n]){
                rotate+=1;
            }
        }
        return rotate>1 ? false:true;
    }
}