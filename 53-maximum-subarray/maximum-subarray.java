class Solution {
    public int maxSubArray(int[] arr) {
        int max=arr[0];
        int curr=arr[0];
        for(int i=1;i<arr.length;i++){
            curr=Math.max(arr[i],curr+arr[i]);
            max=Math.max(max,curr);
            if(curr<0){
                curr=0;
            }
        }
        return max;
    }
//     int max=Integer.MIN_VALUE;
//     int curr=0;
//     for(int i=0;i<arr.length;i++){
//         curr+=arr[i];
//         max=Math.max(curr,max);
//         if(curr<0){
//             curr=0;
//         }
//     }
//     return max;
//   }
}