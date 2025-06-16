// we need to find two subset like that give me |S2-S1|=min diff
//S1+S2=range
// range is overall sum of that array
//s2=range-s1
//|range-2S1|min
//remember doing that range like range is 10 then 0-10 the element after mid automatically comde from that 10-1=9,similar till 5
//so this problem is break down subset sum problem 
// traverse the last row and those are positive we take that and till range/2 not more that becuse ans will come again

class Solution {
        boolean dp[][];
    public int overAll_Sum(int nums[]){
        int sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        return sum;
    }
    public void subsetSum(int arr[],int sum){
        int n=arr.length;
        for(int i=0;i<=n;i++){
            for(int j=0;j<=sum;j++){
                dp[i][0]=true;
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                int v=arr[i-1];
                if(v<=j){
                    dp[i][j]=dp[i-1][j-v] || dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
    }
    public int lastStoneWeightII(int[] nums) {
        int n=nums.length;
        //finding the range
        int range=overAll_Sum(nums);
        dp=new boolean[n+1][range+1];
        //subset sum problem
        subsetSum(nums,range);
        int result=Integer.MAX_VALUE;
        for(int j=0;j<=range/2;j++){
            if(dp[n][j]) {
                int ans=Math.abs(range-2*j);
                result=Math.min(ans,result);
                }
        }
        return result;
    }
}