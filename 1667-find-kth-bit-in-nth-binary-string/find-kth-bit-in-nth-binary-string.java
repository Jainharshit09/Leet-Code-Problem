class Solution {

    public char findKthBit(int n, int k) {
        // Base case: for S1, return '0'
        if (n == 1) return '0';
        int len = 1 << n; // Equivalent to 2^n
        if (k < len / 2) {
            return findKthBit(n - 1, k);
        }
        else if (k == len / 2) {
            return '1';
        }
        else {
            char correspondingBit = findKthBit(n - 1, len - k);
            return (correspondingBit == '0') ? '1' : '0';
        }
    }
}