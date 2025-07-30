class Solution {
    public int longestSubarray(int[] nums) {
        int maxi=Integer.MIN_VALUE;
        for(int i =0;i<nums.length;i++){
            maxi=Math.max(maxi,nums[i]);
        }
        int i=0;
        int j=0;
        int ans=0;
        while(j<nums.length){
            if(nums[j]==maxi){
                ans=Math.max(ans,j-i+1);
            }
            else{
                i=j+1;
            }
            j++;
        }
        return ans;
    }
}