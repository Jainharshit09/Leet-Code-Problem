class Solution {
    public int countSubarrays(int[] arr) {
        int count = 0;
        int n = arr.length;
        for (int i = 1; i < n - 1; i++) {
            int sum=arr[i-1]+arr[i+1];
            if(arr[i]==sum*2){
                count++;
            }
        }
        return count;
    }
}