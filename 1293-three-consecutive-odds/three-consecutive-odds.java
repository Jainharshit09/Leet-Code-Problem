class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        if(arr.length<3){
            return false;
        }
    
    int len=0;
    for(int i=0;i<arr.length;i++){
        if(arr[i]%2==1){
            len++;
        }
        else{
            len=0;
        }

        if(len==3){
            return true;
        }
    }
    return false;
  }
}