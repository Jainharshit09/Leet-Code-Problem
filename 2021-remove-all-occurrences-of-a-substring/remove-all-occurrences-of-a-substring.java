class Solution {
    public boolean check(Stack<Character>stack,String part,int n){
         Stack<Character> temp = new Stack<>();
         temp.addAll(stack);
         for(int i=part.length()-1;i>=0;i--){
            if(temp.isEmpty()||temp.peek()!=part.charAt(i)){
                return false;
            }
            temp.pop();
         }
         return true;
    }
    public String removeOccurrences(String s, String part) {
        Stack<Character>stack=new Stack<>();
        StringBuilder ans=new StringBuilder();
        int n=s.length();
        for(int i=0;i<n;i++){
            stack.push(s.charAt(i));
            if(stack.size()>=part.length() && check(stack,part,part.length())){
                 for (int j = 0; j < part.length(); j++){
                        stack.pop();
                 }
            }
        }
        while(!stack.isEmpty()){
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }
}