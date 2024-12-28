class Solution {
    private int[][] dp = new int[20001][4];

    public int helper(int sum[], int k, int idx, int rem) {
        if (rem == 0)
            return 0;
        if (idx >= sum.length)
            return Integer.MIN_VALUE;
        if(dp[idx][rem]!=-1){
            return dp[idx][rem];
        }
         int take = sum[idx] + helper(sum, k, idx + k, rem - 1);
         int nottake=helper(sum,k,idx+1,rem);
         return dp[idx][rem]=Math.max(take,nottake);
    }

    public void solve(int[] sums, int k, int idx, int rem, List<Integer> indices){
        if(rem==0 || idx >= sums.length){
            return;
        }
        int take=sums[idx] +helper(sums, k, idx + k, rem - 1);
        int nottake=helper(sums,k,idx+1,rem);

        if(take>=nottake){
            indices.add(idx);
            solve(sums,k,idx+k,rem-1,indices);
        }
        else{
            solve(sums,k,idx+1,rem,indices);
        }
    }

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
         for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int n = nums.length - k + 1;
        int sum[]=new int[n];
        int windowSum=0;
         int i = 0, j = 0;
         while(j<nums.length){
             windowSum += nums[j];
             if (j - i + 1 == k){
                sum[i]=windowSum;
                 windowSum -= nums[i];
                 i++;
             }
             j++;
         }
         List<Integer> indices = new ArrayList<>();
          solve(sum, k, 0, 3, indices);
          return indices.stream().mapToInt(Integer::intValue).toArray();
    }
}