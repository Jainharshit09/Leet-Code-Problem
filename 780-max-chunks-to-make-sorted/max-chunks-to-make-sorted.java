class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n=arr.length;
        int curr_sum=0;
        int sum=0;
        int chunks=0;
        for(int i=0;i<n;i++){
            curr_sum+=arr[i];
            sum+=i;
            if(curr_sum==sum){
                chunks++;
            }
        }
        return chunks;
    }
}