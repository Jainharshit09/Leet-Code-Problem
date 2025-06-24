// n is given find how much bst we can create from that
// need to find combination
// for tree combination we can use catalan number 
// for that 2n!/(n+1)!*n! either use that 
import java.math.BigInteger;

class Solution {
    public int numTrees(int n) {
        // We'll store factorials from 0 to 2n
        BigInteger[] fact = new BigInteger[2 * n + 1];
        fact[0] = BigInteger.ONE;
        for (int i = 1; i <= 2 * n; i++) {
            fact[i] = fact[i - 1].multiply(BigInteger.valueOf(i));
        }
        // Catalan number C(n) = (2n)! / ((n+1)! * n!)
        BigInteger catalan = fact[2 * n].divide(fact[n + 1].multiply(fact[n]));

        return catalan.intValue();
    }
}
