// n is given find how much bst we can create from that
// need to find combination
// for tree combination we can use catalan number 
// for that 2n!/(n+1)!*n! either use that 
// or n=3 we can write C0*C2+C1*C1+C2*C0
class Solution {
    public int numTrees(int n) {
        int dp[]=new int [n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<dp.length;i++){
            for(int j=0;j<i;j++){
                dp[i]+=dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }
}