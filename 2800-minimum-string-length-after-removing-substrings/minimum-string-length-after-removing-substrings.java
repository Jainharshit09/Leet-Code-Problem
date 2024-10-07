class Solution {
    public int minLength(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(!st.isEmpty() && ch=='B' && st.peek()=='A'){
               st.pop();
            }
            else if(!st.isEmpty() && ch=='D' && st.peek()=='C'){
               st.pop();
            }
            else{
                st.push(ch);
            }
        }
        return st.size();
    }
}