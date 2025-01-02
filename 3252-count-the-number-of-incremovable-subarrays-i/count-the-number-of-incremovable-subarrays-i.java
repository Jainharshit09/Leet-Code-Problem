class Solution {
    public boolean isincreasing(int arr[],int start ,int end,int n){
        int prev=0;
        for(int i=0;i<n;i++){
            if(i<=end &&i>=start){
                continue;
            }
            if(arr[i]<=prev){
                return false;
            }
            prev=arr[i];
        }
        return true;
    }
    public int incremovableSubarrayCount(int[] nums) {
        int count=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isincreasing(nums,i,j,n)){
                    count++;
                }
            }
        }
        return count;
    }
}