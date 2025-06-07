class Solution {
    public int divide(int dividend, int divisor) {
        //  this will overflow if min int is divided by -1
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // some special cases for max int, just return directly no need to do extra
        if (dividend == Integer.MAX_VALUE && divisor == 1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MAX_VALUE && divisor == -1) {
            return -Integer.MAX_VALUE;
        }

        // figuring out the sign, if both same then +ve else -ve
        boolean sign = true;
        if ((dividend >= 0 && divisor < 0) || (dividend < 0 && divisor >= 0)) {
            sign = false;
        }

        // converting to long so that abs doesn't mess up on edge case like min int
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        int ans = 0;

        // keep subtracting biggest possible multiple of divisor using shift
        while (n >= d) {
            int cnt = 0;
            // find max cnt where (d << cnt+1) is still <= n
            while (n >= (d << (cnt + 1))) {
                cnt++;
            }

            // add 2^cnt to ans (means we subtracted d * 2^cnt)
            ans += (1 << cnt);

            // reduce n by that much
            n -= (d << cnt);
        }

        // apply the sign we calculated earlier
        if (!sign) {
            ans = -ans;
        }

        return ans;
    }
}
