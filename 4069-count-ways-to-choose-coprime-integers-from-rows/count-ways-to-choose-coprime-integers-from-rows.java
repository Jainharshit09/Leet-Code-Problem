//normal question like dp one like form 1 like gcd index and pass aaray only 
//
class Solution {
    int dp[][];
    int MOD = 1_000_000_007;
    public int find(int a,int b){
        while(b!=0){
            int t=b;
            b=a%b;
            a=t;
        }
        return a;
    }
    public int solve(int i,int gcd,int mat[][]){
        if(i==mat.length){
            if(gcd==1)return 1;
            else return 0;
        }
        if(dp[i][gcd]!=-1)return dp[i][gcd];
        int res=0;
        for(int j=0;j<mat[i].length;j++){
            int val=mat[i][j];
            int newGcd=0;
            if(i==0)newGcd=val;
            else{
                newGcd=find(gcd,val);
            }
            res=(res+solve(i+1,newGcd,mat))% MOD;
        }
        return dp[i][gcd]=res;
    }
    public int countCoprime(int[][] mat) {
        dp=new int[151][151];
        int n=mat.length;
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return solve(0,0,mat);
    }
}