class Solution {
    public boolean isPowerOfFour(int n) {
       double power=Math.log10(n)/Math.log10(4);
       return power==(int)power;
    }
}