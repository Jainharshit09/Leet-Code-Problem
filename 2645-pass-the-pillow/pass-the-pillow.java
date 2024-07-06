class Solution {
    public int passThePillow(int n, int time) {
        // int idx=1;
        // int dir=1;
        // while(time>0){
        //     if(idx+dir>=1 && idx+dir<=n){
        //         time--;
        //         idx+=dir;
        //     }
        //     else{
        //         dir*=-1;
        //     }
        // }
        // return idx;

        int full=time/(n-1);
        int remaning=time%(n-1);
        if(full%2!=0){
            return n-remaning;
        }
        else{
           return remaning+1;
        }
    }
}