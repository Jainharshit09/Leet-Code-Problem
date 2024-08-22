class Solution {
    public int bitwiseComplement(int n) {
        if(n==0){
            return 1;
        }
        int bits=(int)(Math.log(n)/Math.log(2))+1;
        for(int i=0;i<bits;i++){
            n=n^(1<<i);
        }
        return n;
    }
}