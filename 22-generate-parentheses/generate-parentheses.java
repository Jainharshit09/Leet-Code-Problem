//this is basic recursion question 
//find the total  generateParenthesis of n
//we can need correct well Parenthesis always start from ( and end with )
//we can having open and close if both equal or && sum of both =2*n add in result and return from that
class Solution {
    public void solve(int open,int close,String s, int n,List<String>res){
        if(open==close && open+close==2*n){
            res.add(s);
            return;
        }
        if(open<n){
            solve(open+1,close,s+"(",n,res);
        }
        if(open>close){
            solve(open,close+1,s+")",n,res);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String>result=new ArrayList<>();
        solve(0,0,"",n,result);
        return result;   
    }
}