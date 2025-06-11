// having 2 option in the array or circular array
// using kadane's algo we can find in the array max sum 
//but for circular we can do find overall sum-min subarray sum max of either the previous equation or maxSum sum using proof of contradiction 
//but if min maxsubarray is negative than we can check max(maxsubarry,overall sum)

// it is combination of min-sum+max-sum overall  kadane's algo

class Solution {
    public int minSubarry(int []arr){
        int curr=arr[0];
        int minsub=arr[0];
        int n=arr.length;
        for(int i=1;i<n;i++){
            curr=Math.min(curr+arr[i],arr[i]);
            minsub=Math.min(curr,minsub);
        }
        return minsub;
    }
    public int maxSubarry(int []arr){
        int curr=arr[0];
        int maxsub=arr[0];
        int n=arr.length;
        for(int i=1;i<n;i++){
            curr=Math.max(curr+arr[i],arr[i]);
            maxsub=Math.max(curr,maxsub);
        }
        return maxsub;
    }
    public int maxSubarraySumCircular(int[] nums) {
        int sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        int minSubarry=minSubarry(nums);
        int maxsubarray=maxSubarry(nums);
        if(maxsubarray<0){
            return Math.max(maxsubarray,sum);
        }
        return Math.max(sum-minSubarry,maxsubarray);
    }
}