class Solution {
    int n, m;
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public void dfs(int i, int j, char[][] board, boolean[][] vis) {
        vis[i][j] = true;
        for (int[] dir : directions) {
            int new_i = i + dir[0];
            int new_j = j + dir[1];
            if (new_i >= 0 && new_i < n && new_j >= 0 && new_j < m && !vis[new_i][new_j] && board[new_i][new_j] == 'O') {
                dfs(new_i, new_j, board, vis);
            }
        }
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        n = board.length;
        m = board[0].length;
        
        // Initialize visited array
        boolean[][] vis = new boolean[n][m];

        // Traverse the boundaries
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O' && !vis[0][j]) {
                dfs(0, j, board, vis);
            }
            if (board[n - 1][j] == 'O' && !vis[n - 1][j]) {
                dfs(n - 1, j, board, vis);
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O' && !vis[i][0]) {
                dfs(i, 0, board, vis);
            }
            if (board[i][m - 1] == 'O' && !vis[i][m - 1]) {
                dfs(i, m - 1, board, vis);
            }
        }

        // Flip captured 'O' to 'X' within the surrounded regions
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && !vis[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
