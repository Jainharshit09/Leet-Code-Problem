class Solution {
    public long solve_min(long sum[],int k){
        long min=0;
        for(int i=0;i<k;i++){
            min+=sum[i];
        }
        return min;
    }
   public long solve_max(long[] arr, int k) {
        long max = 0;
        int n = arr.length;
        for (int i = n - k; i < n; i++) {
            max += arr[i];
        }
        return max;
    }
    public long putMarbles(int[] weights, int k) {
        int n =weights.length;
        long sum[]=new long[n-1];
        for(int i=1;i<n;i++){
            sum[i-1]=weights[i]+weights[i-1];
        }
        Arrays.sort(sum);
        long min=solve_min(sum,k-1);
        long max=solve_max(sum,k-1);
        return max-min;
    }
}
