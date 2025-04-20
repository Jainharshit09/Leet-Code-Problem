class Solution {
    public int maximumPossibleSize(int[] nums) {
        int n=nums.length-1;
        int ans=0;
        int prev=Integer.MIN_VALUE;
        for(int a:nums){
            if(a>=prev){
                ans++;
                prev=a;
            }
        }
        return ans;
    }
}