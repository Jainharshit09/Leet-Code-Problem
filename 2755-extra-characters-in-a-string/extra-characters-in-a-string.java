class Solution {
    int dp[]=new int[51];
    public int solve(String s,Set<String>set,int i,int n){
        if(i>=n){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int result=1+solve(s,set,i+1,n);
        for(int j=i;j<n;j++){
            String curr=s.substring(i,j+1);
            if(set.contains(curr)){
                result=Math.min(result,solve(s,set,j+1,n));
            }
        }
        return dp[i]=result;
    }
    public int minExtraChar(String s, String[] dictionary) {
        int n=s.length();
        Set<String>set=new HashSet<>();
        for(int i=0;i<dictionary.length;i++){
            set.add(dictionary[i]);
        }
        Arrays.fill(dp,-1);
        return solve(s,set,0,n);
    }
}