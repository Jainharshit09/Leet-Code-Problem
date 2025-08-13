class Solution {
    public double log3(int n){
        return  Math.log10(n) / Math.log10(3);
    }
    public boolean isPowerOfThree(int n) {
        if(n<=0)return false;
        return log3(n)==(int)(log3(n));
    }
}