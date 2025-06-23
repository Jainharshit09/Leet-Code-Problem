// in which we check the till last index and string is valid or not
// means for that we do idx-end;
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean dp[]=new boolean[s.length()+1];
        dp[0]=true;
        Set<String> wordSet = new HashSet<>();
        wordSet.addAll(wordDict);
        for(int idx=1;idx<dp.length;idx++){
            for(int end=1;end<=idx;end++){
                dp[idx]=dp[idx]||(dp[idx-end] && wordSet.contains(s.substring(idx-end,idx)));
            }
        }
        return dp[s.length()];
    }
}