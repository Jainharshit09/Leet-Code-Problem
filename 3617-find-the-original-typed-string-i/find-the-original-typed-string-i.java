class Solution {
    public int possibleStringCount(String word) {
         int n = word.length(), ans = 0, i = 0, j = 0;
        while (j < n) {
            if (j + 1 < n && word.charAt(j + 1) == word.charAt(i)) j++;
            else {
                ans += (j - i);
                i = ++j;
            }
        }
        return ans + 1;
    }
}