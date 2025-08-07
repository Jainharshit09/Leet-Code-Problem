//using dp we can easily solve
//having 2 choice if i==n-1 && j==m-1 than return 1 
//in dp store right+down 
// basic recusrion and dp question


//now i understand that these problem can solve by permutation and combination
//because having 2 choice down and right 
//now find how we can do using pnc the formula of pnc is create like n!/r!(n-r)!
//n=m+n-2 and r=min(n,m)-1;



import java.math.BigInteger;

class Solution {
    public int uniquePaths(int m, int n) {
        int total = m + n - 2;
        int r = Math.min(m - 1, n - 1);

        BigInteger[] fact = new BigInteger[total + 1];
        fact[0] = BigInteger.ONE;
        for (int i = 1; i <= total; i++) {
            fact[i] = fact[i - 1].multiply(BigInteger.valueOf(i));
        }

        BigInteger numerator = fact[total];
        BigInteger denominator = fact[r].multiply(fact[total - r]);

        return numerator.divide(denominator).intValue();
    }
}
