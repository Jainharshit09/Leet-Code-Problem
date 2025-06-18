class Solution {
    public String shortestCommonSupersequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        StringBuilder sb=new StringBuilder("");
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
        int i=n,j=m;
        while(i>0 && j>0){
            if(text1.charAt(i-1)==text2.charAt(j-1)){
                   sb.insert(0,text1.charAt(i-1));
                   i--;
                   j--;
                }
                else{
                    // we doin that which one lcs give max move there
                    if(dp[i-1][j]>dp[i][j-1]){
                         sb.insert(0,text1.charAt(i-1));
                         i--;
                    }
                    else{
                        sb.insert(0,text2.charAt(j-1));
                         j--; 
                    }
                }
        }
      //Append remaining characters from text1 and text2
        while(i>0){
             sb.insert(0,text1.charAt(i-1));
                         i--;
        }
        while(j>0){
             sb.insert(0,text2.charAt(j-1));
                         j--;
        }
        return sb.toString();
    }
}