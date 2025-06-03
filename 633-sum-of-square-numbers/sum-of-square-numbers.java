class Solution {
    public boolean judgeSquareSum(int c) {
        int start=0;
        int end=(int)Math.sqrt(c);
    
        while(start<=end){
          long  k=(long)start*start+(long)end*end;
            if(k==c){
                return true;
            }
            if(k<c){
                start++;
            }
            else{
                end--;
            }
        }
        return false;
    }
}