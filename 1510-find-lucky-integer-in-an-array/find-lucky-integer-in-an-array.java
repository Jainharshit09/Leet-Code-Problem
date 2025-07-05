class Solution {
    public int findLucky(int[] arr) {
        int ans[]=new int[501];
        int n=arr.length;
        for(int i=0;i<n;i++){
           ans[ arr[i]]++;
        }
        int result=-1;
        for(int i=500;i>=1;i--){
            if(i==ans[i]){
                result=i;
                break;
            }
        }
        return result;
    }
}