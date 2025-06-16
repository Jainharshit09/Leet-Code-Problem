class Solution {
     public boolean solve(int arr[],boolean vis[],int start,int k,int curr_sum,int sum){
        int n=arr.length;
        if(k==0){
            return true;
        }
        if(curr_sum>sum){
            return false;
        }
        if(curr_sum==sum){
            return solve(arr,vis,0,k-1,0,sum);
        }
        for(int i=start;i<n;i++){
            if(vis[i])continue;
            vis[i]=true;
            if(solve(arr,vis,i+1,k,curr_sum+arr[i],sum)){
                return true;
            }
            vis[i]=false;
        }
        return false;
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int range=Arrays.stream(nums).sum();
        if(range%k!=0)return false;
        int sum=range/k;
        Arrays.sort(nums);
        if(nums[nums.length-1]>sum){
            return false;
        }
        int n=nums.length;
        boolean vis[]=new boolean[n];
        return solve(nums,vis,0,k,0,sum);
    }
}