// we can optimize without taking
// use array and 3 pointer

class Solution {
    public int nthUglyNumber(int n) {
        int dp[]=new int[n];
        dp[0]=1;
        int i2=0;
        int i3=0;
        int i5=0;
        for(int i=1;i<n;i++){
            int nexti2=2*dp[i2];
            int nexti3=3*dp[i3];
            int nexti5=5*dp[i5];

            int next=Math.min(nexti2,Math.min(nexti3,nexti5));
            dp[i]=next;
            if(next==nexti2)i2++;
            if(next==nexti3)i3++;
            if(next==nexti5)i5++;
        }
        return dp[n-1];
    }
}