class Solution {
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
        int ans=0;
        while(l<=max){
            int mid=(l+max)/2;
            long count=0;
            for(int i=0;i<n;i++){
                count+=candies[i]/mid;
            }
            if(count>=k){
                ans=mid;
                l = mid + 1;
            }
            else {
                max=mid-1;
            }
        }
        return ans;
    }
}