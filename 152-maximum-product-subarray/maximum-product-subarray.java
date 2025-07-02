class Solution {
    public int maxProduct(int[] nums) {
        int maxP=Integer.MIN_VALUE;
        int prod=1;
        int n=nums.length;
        for(int i=0;i<n;i++){
            prod*=nums[i];
            maxP=Math.max(prod,maxP);
            if(prod==0){
                prod=1;
            }
        }
        prod=1;
        for(int i=n-1;i>=0;i--){
            prod*=nums[i];
            maxP=Math.max(prod,maxP);
            if(prod==0){
                prod=1;
            }
        }
        return maxP;
    }
}