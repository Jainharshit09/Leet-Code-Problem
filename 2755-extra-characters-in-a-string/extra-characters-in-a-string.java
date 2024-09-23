class Solution {
    public int minExtraChar(String s, String[] dict) {
        int n=s.length();
        int dp[]=new int[n+1];
        Arrays.fill(dp,0);
        Set<String> set=new HashSet<>();
        for(int i=0;i<dict.length;i++){
            set.add(dict[i]);
        }
        for(int i=n-1;i>=0;i--){
            dp[i]=1+dp[i+1];
            for(int j=i;j<n;j++){
                String curr=s.substring(i,j+1);
                if(set.contains(curr)){
                    dp[i]=Math.min(dp[i],dp[j+1]);
                }
            }
        }
        return dp[0];
    }
}