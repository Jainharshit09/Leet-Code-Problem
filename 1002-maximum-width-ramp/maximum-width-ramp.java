class Solution {
    public int maxWidthRamp(int[] nums) {
        int n=nums.length;
        int ans=0;
        int arr[]=new int [n];
        int max=nums[n-1];
        for(int i=n-1;i>=0;i--){
          max=Math.max(max,nums[i]);
            arr[i]=max;
        }
        int s=0;
        int j=0;
        while(s<n && j<arr.length){
            if(nums[s]<=arr[j]){
                j++;
                ans=Math.max(ans,j-s-1);
            }
           else if(nums[s]>arr[j]){
                s++;
            } 
        }
        return ans;
    }
}