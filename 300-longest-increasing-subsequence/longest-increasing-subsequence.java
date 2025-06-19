class Solution {
    int dp[][]=new int[2501][2501];
    int n;
    public int solve(int nums[],int i,int parent){
        if(i>=n){
            return 0;
        }
        if(parent!=-1 && dp[i][parent]!=-1){
            return dp[i][parent];
        }
        int take=-1;
        if(parent==-1 || nums[parent]<nums[i]){
            take=1+solve(nums,i+1,i);
        }
        int skip=solve(nums,i+1,parent);
        if(parent!=-1){
            dp[i][parent]=Math.max(skip,take);
        }
        return Math.max(skip,take);
    }
    public int lengthOfLIS(int[] nums) {
        n=nums.length;
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return solve(nums,0,-1);
    }
}