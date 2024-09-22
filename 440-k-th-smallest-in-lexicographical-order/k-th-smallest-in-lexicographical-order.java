class Solution {
    public int solve(long curr,long next,int n){
        int ans=0;
        while(curr<=n){
            ans+=Math.min(next,(long)n+1)-curr;
            curr*=10;
            next*=10;
        }
        return ans;
    }
    public int findKthNumber(int n, int k) {
        int curr=1;
        k-=1;
        while(k>0){
            int count=solve(curr,curr+1,n);
            if(count<=k){
                curr++;
                k-=count;
            }
            else{
                curr*=10;
                k-=1;
            }
        }
        return curr;
    }
}