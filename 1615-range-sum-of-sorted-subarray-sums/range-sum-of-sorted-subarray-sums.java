class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int ans[]=new int[n * (n + 1) / 2];
        int MOD = 1_000_000_007;
        int index=0;
        ans[0]=nums[0];
        for (int i = 0; i < n; i++) {
            int sum = 0;
           for (int j = i; j < n; j++) {
                sum += nums[j];
                ans[index++] = sum;
            }
        }
        Arrays.sort(ans);
        int result=0;
        for(int i=left-1;i<right;i++){
            result=(result + ans[i]) % MOD;
        }
        return result;
    }
}