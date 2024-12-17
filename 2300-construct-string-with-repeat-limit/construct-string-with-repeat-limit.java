class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int n = s.length();
        int count[] = new int[26];
        for (int i = 0; i < n; i++) {
            int ch = s.charAt(i) - 'a';
            count[ch]++;
        }
        StringBuilder str = new StringBuilder();
        int i=25;
       while(i>=0) {
            int freq = count[i];
            if (freq == 0) {
                i--;
                continue;
            }
            int c = Math.min(freq, repeatLimit);
            for (int j = 0; j < c; j++) {
                str.append((char) (i + 'a'));
            }
            count[i] -= c;
            if (count[i] > 0) {
                int prev = i - 1;
                while (prev >= 0 && count[prev] == 0) {
                    prev--;
                }
                if (prev < 0) {
                    break;
                }
                str.append((char) (prev + 'a'));
                count[prev]--;
            } 
        }
        return str.toString();
    }
}
