class Solution {
    public String clearDigits(String s) {
        Stack<Character> stack=new Stack<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(Character.isDigit(ch) && !stack.isEmpty()){
                stack.pop();
            }
            if(!Character.isDigit(ch))stack.push(ch);
        }
        StringBuilder ans=new StringBuilder();
        while(!stack.isEmpty()){
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }
}