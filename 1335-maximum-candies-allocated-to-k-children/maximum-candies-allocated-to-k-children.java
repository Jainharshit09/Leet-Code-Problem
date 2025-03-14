class Solution {
        private boolean canDistr(int[] candies, int mid, long k) {
        int n = candies.length;

        for (int i = 0; i < n; i++) {
            k -= candies[i] / mid;

            if (k <= 0) {
                return true;
            }
        }

        return k <= 0;
    }
    public int maximumCandies(int[] candies, long k) {
        int n=candies.length;
        long total=0;
        int max=0;
        for(int i=0;i<n;i++){
            total+=candies[i];
            max=Math.max(max,candies[i]);
        }
        if(total<k){
            return 0;
        }
        int l=1;
        int r=max;
        int ans=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            if (canDistr(candies, mid, k)){
                ans=mid;
                l = mid + 1;
            }
            else {
                r=mid-1;
            }
        }
        return ans;
    }
}