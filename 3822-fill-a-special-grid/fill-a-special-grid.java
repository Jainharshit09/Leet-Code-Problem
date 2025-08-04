//please focous in reading question other it will fuck your mind f
// we need 1 2 3 4 quardant and the quardant will be fill 2<4<3<1
// we can do using recusion like in n=3 8*8 matrix will be there 1,2,3,4 for 2 there is also same quardant 1,2,3,4 than for also each one so go with recursion
// like fill 2 quardant -> 4th ->3rd -> 1st
class Solution {
    int val=0;
    public void solve (int ans[][],int row,int col,int size){
        if(size==1){
            ans[row][col]=val++;
            return;
        }
        int curr_size=size/2;

        // for 2nd quardant col+curr_size
        solve(ans,row,col+curr_size,curr_size);

        // for 4rd quardant
        solve(ans,row+curr_size,col+curr_size,curr_size);

        // for 3rd quardant
        solve(ans,row+curr_size,col,curr_size);

        //for 1st quardant
        solve(ans,row,col,curr_size);
    }
    public int[][] specialGrid(int n) {
        if(n==0)return new int[][]{{0}};
        int size=1<<n;
        int ans[][]=new int[size][size];
        solve(ans,0,0,size);
        return ans;
    }
}