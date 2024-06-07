class Solution {
    int n,m;
    boolean vis[][];
    int direction[][]={{0,1},{1,0},{0,-1},{-1,0}};
    public void dfs(int i,int j,char board[][]){
        vis[i][j]=true;
        for(int[] dir : direction){
            int new_i=i+dir[0];
            int new_j=j+dir[1];
            if(new_i>=0 &&  new_i<n && new_j>=0 && new_j<m &&!vis[new_i][new_j]&& board[new_i][new_j]=='O'){
                dfs(new_i,new_j,board);
            }
        }
    }
    public void solve(char[][] board) {
        n=board.length;
        m=board[0].length;
        // 1 st row
        vis = new boolean[n][m];
        for(int j=0;j<m;j++){
            if(board[0][j]=='O' && !vis[0][j]){
                dfs(0,j,board);
            }
            //last row
             if(board[n-1][j]=='O' && !vis[n - 1][j]){
                dfs(n-1,j,board);
            }
        }
        // 1st col
        for(int i=0;i<n;i++){
            if(board[i][0]=='O' && !vis[i][0]){
                dfs(i,0,board);
            }
            // col
             if(board[i][m-1]=='O' && !vis[i][m - 1]){
                dfs(i,m-1,board);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O'&& !vis[i][j]){
                    board[i][j]='X';
                }
            }
        }
    }
}