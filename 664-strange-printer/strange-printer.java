class Solution {
    int dp[][];
    public int solve(String s,int l,int r){
        if(l==r){
            return 1;
        }
        if(l>r){
            return 0;
        }
        if(dp[l][r]!=-1){
            return dp[l][r];
        }
        int i=l+1;
        while(i<=r && s.charAt(i)==s.charAt(l)){
            i++;
        }
        if(i==r+1){
            return 1;
        }
        int basic=1+solve(s,i,r);
        int result=Integer.MAX_VALUE;
        for(int j=i;j<=r;j++){
            if( s.charAt(j)==s.charAt(l)){
                int ans=solve(s,i,j-1)+solve(s,j,r);
                result=Math.min(result,ans);
            }
        }
        return dp[l][r]=Math.min(result,basic);
    }
    public int strangePrinter(String s) {
        int n=s.length();
        dp=new int[n+1][n+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<n+1;j++){
                dp[i][j]=-1;
            }
        }
        int r=s.length()-1;
        int l=0;
        return solve(s,l,r);
    }
}