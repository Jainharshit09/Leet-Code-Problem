class Solution {
    public boolean canBeValid(String s, String locked) {
        int n=s.length();
        if(n%2==1){
            return false;
        }
        Stack<Integer>str=new Stack<>();
        Stack<Integer> lc=new Stack<>();
        for(int i=0;i<n;i++){
            int idx=locked.charAt(i)-'0';
            if(idx!=1){
                lc.add(i);
            }
           else if(s.charAt(i)=='('){
                str.add(i);
            }
            else if(s.charAt(i)==')'){
                if(!str.isEmpty()){
                    str.pop();
                }
                else if(!lc.isEmpty()){
                    lc.pop();
                }
                else{
                    return false;
                }
            }
        }
        while(!str.isEmpty() && !lc.isEmpty()){
            int str_idx=str.pop();
            int lc_idx=lc.pop();
            if(str_idx>lc_idx){
                return false;
            }
        }
        return str.isEmpty();
    }
}