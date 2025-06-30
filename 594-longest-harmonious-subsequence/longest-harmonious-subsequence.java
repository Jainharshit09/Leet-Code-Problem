class Solution {
    public int findLHS(int[] nums) {
        int n=nums.length;
        int ans=0;
        int i=0;
        int j=0;
        Arrays.sort(nums);
        while(j<n){
           
            if(nums[j]-nums[i]==1){
                ans=Math.max(ans,j-i+1);
            }
            while(nums[j]-nums[i]>1){
                i++;
            }
            j++;
        }
        return ans;
    }
}