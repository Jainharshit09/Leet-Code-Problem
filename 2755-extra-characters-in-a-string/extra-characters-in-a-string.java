class Solution {
    int dp[]=new int[51];
    public int solve(int i,String s, Set<String> set,int n){
        if(i>=n){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int result=1+solve(i+1,s,set,n);
        for(int j=i;j<n;j++){
            String curr=s.substring(i,j+1);
            if(set.contains(curr)){
                result = Math.min(result, solve(j + 1, s, set, n));
            }
        }
        dp[i]=result;
        return result;
    }
    public int minExtraChar(String s, String[] dict) {
        Set<String> set=new HashSet<>();
        int n=s.length();
        for(int i=0;i<dict.length;i++){
            set.add(dict[i]);
        }
        Arrays.fill(dp,-1);
        return solve(0,s,set,n);
    }
}