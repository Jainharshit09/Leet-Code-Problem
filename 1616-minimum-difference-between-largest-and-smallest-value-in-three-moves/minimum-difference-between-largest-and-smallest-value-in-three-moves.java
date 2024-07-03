class Solution {
    public int minDifference(int[] nums) {
        if(nums.length<=4){
            return 0;
        }
        Arrays.sort(nums);
        int n=nums.length;
        int a1=nums[n-4]-nums[0];
        int a2=nums[n-1]-nums[3];
        int a3=nums[n-2]-nums[2];
        int a4=nums[n-3]-nums[1];
        int ans=Math.min(a1,a2);
        int ans2=Math.min(a3,a4);
        int result=Math.min(ans,ans2);
        return result;
    }
}