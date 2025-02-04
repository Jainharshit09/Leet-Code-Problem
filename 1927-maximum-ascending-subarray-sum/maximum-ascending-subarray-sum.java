class Solution {
    public int maxAscendingSum(int[] nums) {
        int ans=0;
        int sum=nums[0];
        int n=nums.length;
        for(int i=1;i<n;i++){
            if(nums[i]<=nums[i-1]){
               ans=Math.max(ans,sum);
               sum=0;
            }
            sum+=nums[i];
        }
        return Math.max(ans,sum);
    }
}