class Solution {
    int dp[][]=new int[1001][1001];
    public int solve(int currA, int clipA, int n) {
        if (currA==n) {
            return 0;
        }
        if (currA>n) {
            return 100000;
        }
        if(dp[currA][clipA]!=-1){
            return dp[currA][clipA];
        }
        int copyall=1+1+ solve(currA+currA,currA,n);
        int paste=1+solve(currA+clipA,clipA,n);
        return dp[currA][clipA]= Math.min(copyall,paste);
    }

    public int minSteps(int n) {
        if(n==1){
            return 0;
        }
        for(int i=0;i<1001;i++){
            for(int j=0;j<1001;j++){
                dp[i][j]=-1;
            }
        }
        return  1+solve(1,1,n);
    }
}