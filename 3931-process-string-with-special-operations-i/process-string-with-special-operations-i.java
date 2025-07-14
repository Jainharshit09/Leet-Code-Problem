//if char append in reuslt
//* remove last one
//# append it to itself
// % reverse the result;
class Solution {
    public String processStr(String s) {
        StringBuilder ans=new StringBuilder();
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='*'){
                if(ans.isEmpty())continue;
                ans.deleteCharAt(ans.length() - 1);
            }
            else if(ch=='#'){
                if(ans.isEmpty())continue;
                ans.append(ans);
            }
            else if(ch=='%'){
                if(ans.isEmpty())continue;
                  ans.reverse();
            }
            else{
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}