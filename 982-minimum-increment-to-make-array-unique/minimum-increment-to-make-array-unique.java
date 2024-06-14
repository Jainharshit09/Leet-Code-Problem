class Solution {
    public int minIncrementForUnique(int[] nums) {
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            maxi=Math.max(nums[i],maxi);
        }
        int p=nums.length+maxi;
        int n[]=new int [p];
        for(int i=0;i<nums.length;i++){
            int k=nums[i];
            n[k]=n[k]+1;
        }
        int ans=0;
        for(int i=0;i<n.length;i++){
            if(n[i]==0 || n[i]==1){
                continue;
            }
            int k=n[i];
            n[i]=1;
            n[i+1]=n[i+1]+k-1;
            ans+=k-1;

        }
        return ans;
    }
}