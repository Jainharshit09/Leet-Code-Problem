import java.util.Stack;

class Solution {
    public int minimumDeletions(String st) {
        Stack<Character> s = new Stack<>();
        int count = 0;

        for (int i = 0; i < st.length(); i++) {
            if (!s.isEmpty() && s.peek() == 'b' && st.charAt(i) == 'a') {
                s.pop();
                count++;
            }
            else{
                s.push(st.charAt(i));
            }
        }
        return count;
    }
}
