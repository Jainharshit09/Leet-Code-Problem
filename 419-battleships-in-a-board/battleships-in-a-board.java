class Solution {
    public int countBattleships(char[][] board) {
        int ans=0;
        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i>=0 && j>=0 && i<n && j<m && board[i][j]=='X'){
                    if(i>0 && board[i-1][j]=='X'){
                        continue;
                    }
                    if(j>0 && board[i][j-1]=='X'){
                        continue;
                    }
                    else{
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}