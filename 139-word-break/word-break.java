// normal recursion problem
// check in set that string present or not
// present return  do for next one using rec will give 
class Solution {
    Boolean dp[];
    int n;
    public boolean solve(String s,int idx, List<String> wordDict){
        if(idx>=n){
            return true;
        } 
        if(wordDict.contains(s)){
            return true;
        }
        if(dp[idx]!=null){
            return dp[idx];
        }
        for(int end=idx+1;end<=n;end++){
            String str=s.substring(idx,end);
            if(wordDict.contains(str) && solve(s,end,wordDict)){
                return dp[idx]=true;
            }
        }
        return dp[idx]=false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        n=s.length();
        dp=new Boolean[301];
        return solve(s,0,wordDict);
    }
}