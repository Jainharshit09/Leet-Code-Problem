class Solution {
    int dp[]=new int[501];
    public int solve(int arr[],int k,int i){
        if(i>=arr.length){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int result=0;
        int currmax=-1;
        for(int j=i;j<arr.length && j-i+1<=k;j++){
            currmax=Math.max(currmax,arr[j]);
            result=Math.max(result,((j-i+1)*currmax)+solve(arr,k,j+1));
        }
        return dp[i]=result;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        Arrays.fill(dp,-1);
        return solve(arr,k,0);

    }
}