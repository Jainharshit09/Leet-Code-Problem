
class Solution {
    public void markGuarded(int row, int col, int[][] grid) {
        // UP
        for (int i = row - 1; i >= 0; i--) {
            if (grid[i][col] == 1 || grid[i][col] == 2) {
                break;
            }
            grid[i][col] = 3;
        }

        // down
        for (int i = row + 1; i < grid.length; i++) {
            if (grid[i][col] == 1 || grid[i][col] == 2) {
                break;
            }
            grid[i][col] = 3;
        }

        // left
        for (int j = col - 1; j >= 0; j--) {
            if (grid[row][j] == 1 || grid[row][j] == 2) {
                break;
            }
            grid[row][j] = 3; // Marking as guarded
        }

        // right
        for (int j = col + 1; j < grid[0].length; j++) {
            if (grid[row][j] == 1 || grid[row][j] == 2) {
                break;
            }
            grid[row][j] = 3; // Marking as guarded
        }
    }

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 1;
        }
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 2; // Wall: 2
        }
        int count = 0;
        for (int[] guard : guards) {
            int i = guard[0];
            int j = guard[1];
            markGuarded(i, j, grid);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}