class Solution {
    int n;
    int width;
    int dp[][];
    public int solve(int books[][],int i,int remaning,int maxe){
        if(i>=n){
            return maxe;
        }
        if(dp[i][remaning]!=-1){
            return dp[i][remaning];
        }
        int bookW=books[i][0];
        int bookH=books[i][1];
        int keep=Integer.MAX_VALUE;
        int skip=Integer.MAX_VALUE;
        //keep
        if(bookW<=remaning){
            keep=solve(books,i+1,remaning-bookW,Math.max(maxe,bookH));
        }
            skip=maxe+solve(books,i+1,width-bookW,bookH);

        
        return dp[i][remaning]=Math.min(keep,skip);
    }
    public int minHeightShelves(int[][] books, int shelfWidth) {
         dp=new int[1001][1001];
           for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        n=books.length;
        width=shelfWidth;
        int remaning=shelfWidth;
         return solve(books,0,remaning,0);
    }
}