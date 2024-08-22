class Solution {
    public int findComplement(int num) {
        int bits=(int)(Math.log(num)/Math.log(2))+1;
        for(int i=0;i<bits;i++){
            num=num^(1<<i);
        }
        return num;
    }

}