class Solution {
    public int solve(int arr[],int index,int curr_xor,int max_xor){
        if(index==arr.length){
            return (curr_xor==max_xor)?1:0;
        }
        int include=solve(arr,index+1,arr[index]|curr_xor,max_xor);
        int not_include=solve(arr,index+1,curr_xor,max_xor);
        return include+not_include;
    }
    public int countMaxOrSubsets(int[] nums) {
        int maxor=0;
        for(int i=0;i<nums.length;i++){
            maxor|=nums[i];
        }
        return solve(nums,0,0,maxor);
    }
}