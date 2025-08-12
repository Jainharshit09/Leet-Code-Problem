//like x is small
//but n is large 
//in which like we can find max digit of 1 to n that will go till like 
// for ex:1 n=10  1,2,3 if i take 4 will 4^x=16 and it is already greater than n no need to take now in array 
//now having choice and means go with recursion
// but get tle because n is not large but to many sub problem will come so that use memo
//for power we can use binary exponatation


// we take i=1 like choice take or not if i^x>n than return 0
// we we get ans than take both count taking+not taking
// 

class Solution {
    final int MOD = 1_000_000_007;
    public int binary_Exp(int base, int exp) {
        long result = 1;
        long b = base;
        while (exp > 0) {
            if ((exp & 1) == 1)
                result *= b;
            b *= b;
            exp >>= 1;
        }
        return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) result;
    }
    int dp[][];
    public int solve(int n,int i,int x){
        int power=binary_Exp(i,x);
        if(n==0)return 1;
        if(power>n)return 0;
        if(dp[n][i]!=-1)return dp[n][i];
        int take=solve(n-power,i+1,x);
        int not_take=solve(n,i+1,x);
        return dp[n][i]=(take+not_take)%MOD;
    }
    public int numberOfWays(int n, int x) {
        int maxBase = 1;
        while (binary_Exp(maxBase, x) <= n) {
            maxBase++;
        }
        dp=new int[n+1][maxBase+2];
        for(int row[]:dp)Arrays.fill(row,-1);
        return solve(n,1,x);
    }
}