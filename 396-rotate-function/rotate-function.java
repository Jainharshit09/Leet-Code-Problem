class Solution {
    public int maxRotateFunction(int[] nums) {
        int sum=0;
        int n=nums.length;
        int value=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            int temp=nums[i]*i;
            value+=temp;
        }
        int ans=value;
        for(int i=1;i<n;i++){
            value=value+sum-(nums[n-i]*n);
            ans=Math.max(ans,value);
            
        }
        return ans;
    }
}