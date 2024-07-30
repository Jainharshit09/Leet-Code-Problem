class Solution {
    public int minimumDeletions(String st) {
        int countB = 0;
        int deletions = 0;

        for (int i = 0; i < st.length(); i++) {
            if (st.charAt(i) == 'b') {
                countB++;
            } else if (st.charAt(i) == 'a') {
                if (countB > 0) {
                    deletions++;
                    countB--;
                }
            }
        }

        return deletions;
    }
}
