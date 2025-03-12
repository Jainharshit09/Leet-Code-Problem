class Solution {
    int n;
    public int upper(int nums[]){
        int low=0;
        int end=n-1;
        int index=n;
        while(low<=end){
            int mid=(low+end)/2;
            if(nums[mid]<=0){
                low=mid+1;
            }
            else if(nums[mid]>0){
                end=mid-1;
                index=mid;
            }
        }
        return index;
    }
    public int lower(int nums[]){
        int low=0;
        int end=n-1;
        int index=n;
        while(low<=end){
            int mid=(low+end)/2;
            if(nums[mid]<0){
                low=mid+1;
            }
            else if(nums[mid]>=0){
                end=mid-1;
                index=mid;
            }
        }
        return index;
    }
    public int maximumCount(int[] nums) {
        n=nums.length;
        int pos=n-upper(nums);
        int neg=lower(nums);
        return Math.max(neg,pos);
    }
}