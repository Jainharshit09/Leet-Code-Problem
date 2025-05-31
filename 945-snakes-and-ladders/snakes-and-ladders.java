class Solution {
    int n;
    public int[] getCoord(int s){
        int row=n-1-(s-1)/n;
        int col=(s-1)%n;
        if((n%2==1 && row%2==1) || (n%2==0 && row%2==0)){
            col=n-1-col;
        }
        return new int[]{row,col};
    }
    public int snakesAndLadders(int[][] board) {
         n=board.length;
        int step=0;
        Queue<Integer>q=new LinkedList<>();
        boolean vis[][]=new boolean [n][n];
        vis[n-1][0]=true;
        q.add(1);
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                int x=q.poll();
                if(x==n*n){
                    return step;        
                }
                for(int k=1;k<=6;k++){
                    int val=x+k;
                     if(val>n*n){
                        break;
                     }
                     int[] coord = getCoord(val);
                     int row=coord[0];
                     int col=coord[1];
                     if(vis[row][col])continue;
                     vis[row][col]=true;
                     if(board[row][col]==-1){
                        q.add(val);
                     }
                     else{
                        q.add(board[row][col]);
                     }
                }
            }
            step++;
        }
        return -1;

   }
}