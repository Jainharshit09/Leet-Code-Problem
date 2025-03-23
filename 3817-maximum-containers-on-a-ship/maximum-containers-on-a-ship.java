class Solution {
    public int maxContainers(int n, int w, int maxWeight) {
        int l=1;
        int r=n*n;
        int ans=0;
        while(l<=r){
            int mid=(l+r)/2;
            if(mid*w<=maxWeight){
                ans=mid;
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return ans;
    }
}