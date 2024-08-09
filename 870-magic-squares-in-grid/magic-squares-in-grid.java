class Solution {
    public boolean solve(int grid[][],int r,int c){
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                int num=grid[r+i][j+c];
                if(num<1 || num>9||set.contains(num)){
                    return false;
                }
                else{
                    set.add(num);
                }
            }
        }
        int sum=grid[r][c]+grid[r][c+1]+grid[r][c+2];
        for(int i=0;i<3;i++){
            if (grid[r + i][c] + grid[r + i][c + 1] + grid[r + i][c + 2] != sum) {
                return false;
            }
            if (grid[r][c + i] + grid[r + 1][c + i] + grid[r + 2][c + i] != sum) {
                return false;
            }
        }
         if (grid[r][c] + grid[r + 1][c + 1] + grid[r + 2][c + 2] != sum) {
            return false;
        }
        if (grid[r][c + 2] + grid[r + 1][c + 1] + grid[r + 2][c] != sum) {
            return false;
        }

        return true;
    }
    public int numMagicSquaresInside(int[][] grid) {
        int count=0;
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<=n-3;i++){
            for(int j=0;j<=m-3;j++){
                if(solve(grid,i,j)){
                    count++;
                }
            }
          
        }
        return count;
    }
}