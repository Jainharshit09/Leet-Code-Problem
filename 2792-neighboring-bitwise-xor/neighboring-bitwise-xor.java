class Solution {
    public boolean doesValidArrayExist(int[] arr) {
        int n=arr.length;
        int xor=0;
        for(int i=0;i<n;i++){
            xor^=arr[i];
        }
        if(xor==0){
            return true;
        }
        return false;
    }
}