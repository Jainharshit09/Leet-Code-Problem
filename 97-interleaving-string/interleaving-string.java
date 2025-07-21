// first go with two pointer but fail in at same char both s1 and s2 having same
// now same will give me choice which one i need to choose
//this means choice is there go recursion/dp
// like continue with 1st index and move with 2nd index and same vice versa
// which one give me true return that remember doing or in the end because either taking s1 or s2 one will give true
class Solution {
    Boolean dp[][];
    public boolean dfs(int i,int j,String s1,String s2,String s3){
        if(dp[i][j]!=null)return dp[i][j];
        if(i == s1.length() && j== s2.length())return true;
        
        int k=i+j;
        boolean ans=false;
        if(i<s1.length() && s1.charAt(i)==s3.charAt(k)){
           ans=ans || dfs(i+1,j,s1,s2,s3);
        }
        if(j<s2.length() && s2.charAt(j)==s3.charAt(k)){
           ans=ans || dfs(i,j+1,s1,s2,s3);
        }
        dp[i][j]=ans;
        return ans;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        dp=new Boolean[s1.length()+1][s2.length()+1];
        if(s1.length()+s2.length()!=s3.length())return false;
        if(s1.isEmpty() && s2.isEmpty() && s3.isEmpty())return true;
        return dfs(0,0,s1,s2,s3);
    }
}