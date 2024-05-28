class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n=s.length();
        int ans = 0;
        int currentCost = 0;
        int start = 0;

        for (int i = 0; i < n; i++) {
            currentCost += Math.abs(s.charAt(i) - t.charAt(i));

            while (currentCost > maxCost) {
                currentCost -= Math.abs(s.charAt(start) - t.charAt(start));
                start++;
            }

            ans = Math.max(ans, i - start + 1);
        }

        return ans;
    }
}