class Solution {
     public int longestCommonSubsequence(String text1, String text2) {
        int n= text1.length();
        int m=text2.length();
        int dp[][]=new int [n+1][m+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i==0||j==0){dp[i][j]=0;}
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder(s);
        String s2 = sb.reverse().toString();
        return longestCommonSubsequence(s,s2);
    }
}