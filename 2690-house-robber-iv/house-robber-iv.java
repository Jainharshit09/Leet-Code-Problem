class Solution {
    int n;
    public boolean solve(int nums[],int cap,int k){
        int count=0;
        for(int i=0;i<n;i++){
            if(nums[i]<=cap){
                count++;
                i++;
            }
            if(count>=k){
                return true;
            }
        }
        return false;
    }
    public int minCapability(int[] nums, int k) {
         n=nums.length;
        int ans=0;
        int l=Integer.MAX_VALUE;
        int r=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            l=Math.min(l,nums[i]);
            r=Math.max(r,nums[i]);
        }
        while(l<=r){
            int mid=l+(r-l)/2;
            if(solve(nums,mid,k)){
                ans=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
}