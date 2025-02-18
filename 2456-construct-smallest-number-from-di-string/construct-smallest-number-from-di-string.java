class Solution {
    public void backtrack(String pattern,int idx,boolean[] used, StringBuilder sb, StringBuilder current, int n){
         if (current.length() == n + 1) {
            sb.setLength(0);
            sb.append(current.toString());
            return;
        }
        for(int digit=1;digit<=9;digit++){
            if (used[digit - 1]) continue;
            //do
            used[digit - 1] = true;
            current.append(digit);

            //explore
            if (isValid(pattern, idx, current)) {
                backtrack(pattern, idx + 1, used, sb, current, n);
                if (sb.length() > 0) return;
            }
            //undo
            used[digit - 1] = false;
            current.deleteCharAt(current.length() - 1);
        }
    }
        private boolean isValid(String pattern, int idx, StringBuilder current) {
        if (idx == 0) return true;
        char prevChar = pattern.charAt(idx - 1);
        int prevDigit = current.charAt(idx - 1) - '0';
        int currentDigit = current.charAt(idx) - '0';

        if (prevChar == 'I' && prevDigit >= currentDigit) return false;
        if (prevChar == 'D' && prevDigit <= currentDigit) return false;

        return true;
    }
    public String smallestNumber(String pattern) {
        boolean used[]=new boolean[9];
         int n = pattern.length();
        StringBuilder sb = new StringBuilder();
        backtrack(pattern, 0, used, sb, new StringBuilder(), n);
        return sb.toString();
    }
}