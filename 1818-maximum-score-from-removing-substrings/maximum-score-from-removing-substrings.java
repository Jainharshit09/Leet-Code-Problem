class Solution {


    public int solve(StringBuilder str,int x,int y,char first,char second){
        Stack<Character>s=new Stack<>();
        int ans=0;
        for(char ch:str.toString().toCharArray()){
            s.push(ch);
            if(s.size()>=2 && s.get(s.size() - 2)==first && s.peek()==second){
                s.pop();
                s.pop();
                ans+=x;
            }
        }
        str.setLength(0);
        while(!s.isEmpty()){
            str.append(s.pop());
        }
        str=str.reverse();
        for(char ch:str.toString().toCharArray()){
             s.push(ch);
            if(s.size()>=2 && s.get(s.size() - 2)==second && s.peek()==first){
                s.pop();
                s.pop();
                ans+=y;
            }
        }
        return ans;
    }




    public int maximumGain(String s, int x, int y) {
        if(x<y){
            return solve(new StringBuilder(s),y,x,'b','a');
        }
        else{
             return solve(new StringBuilder(s),x,y,'a','b');
        }
    }

}