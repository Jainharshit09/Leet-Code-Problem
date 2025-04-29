class Solution {
    public long countSubarrays(int[] nums, int k) {
       int m=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            m=Math.max(nums[i],m);
        }
        int  max = m;
        int n=nums.length;
        int i=0;
        int j=0;
        int count =0;
        long result=0;
        while(j<n){
            if(nums[j]==max){
                count++;
            }
            while(count>=k){
                result+=n-j;
                if(nums[i]==max){
                    count--;
                }
                i++;
            }
            j++;
        }
        return result;
    }
}