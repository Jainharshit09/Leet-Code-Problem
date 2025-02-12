class Solution {
    public int find(int num){
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    public int maximumSum(int[] nums) {
      int arr[]=new int[82];
      int result = -1;
      Arrays.fill(arr,0);
      int n=nums.length;
      for(int i=0;i<n;i++){
        int sum=find(nums[i]);
        if(arr[sum]>0){
             result = Math.max(result, nums[i] + arr[sum]);
        }
        arr[sum]=Math.max(arr[sum],nums[i]);
      }
      return result;
    }
}