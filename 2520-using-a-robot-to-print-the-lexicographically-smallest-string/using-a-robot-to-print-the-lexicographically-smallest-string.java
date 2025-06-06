class Solution {
    // in that find the next smallest character and push in stack then check with minchar if it small then store in ans till we can got bigger and than in end also need to check stack is empty or not if not then store in ans
    public String robotWithString(String s) {
        int n=s.length();
        char[] nsl=new char[n];
        nsl[n-1]=s.charAt(n-1);
        for(int i=n-2;i>=0;i--){
            nsl[i]=(char)Math.min(nsl[i+1],s.charAt(i));
        }
        Stack<Character>stack=new Stack<>();
        StringBuilder ans=new StringBuilder();
        int i=0;
        while(i<n){
            stack.push(s.charAt(i));
            char minChar = (i + 1 < n) ? nsl[i + 1] : s.charAt(i);
             while(!stack.isEmpty() && stack.peek() <=minChar){
                ans.append(stack.pop());
             }
             i++;
        }

        while(!stack.isEmpty()){
            ans.append(stack.pop());
        }
        return ans.toString();
    }
}