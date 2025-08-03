//observation
// if go left than go left and collect than go right similar vice versa
// we can pre count all amount is prefix sum;

class Solution {
     private int lowerBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    // Helper method to find the upper bound index
    private int upperBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n=fruits.length;
        int prefix[]=new int[n];
        int position[]=new int[n];
        for(int i=0;i<n;i++){
            position[i]=fruits[i][0];
            prefix[i]=fruits[i][1]+(i>0 ? prefix[i-1]:0);
        }

        int maxFruit=0;
        for(int d=0;d<=k/2;d++){
            //case move d step left;
            int remain=k-2*d;
            int i=startPos-d;
            int j=startPos+remain;
            int left=lowerBound(position,i);
            int right=upperBound(position,j)-1;
            if(left<=right){
                int total=prefix[right]-(left>0 ? prefix[left-1]:0);
                maxFruit=Math.max(maxFruit,total);
            }
            // case 2 move d to right 
            i=startPos-remain;
            j=startPos+d;
            left=lowerBound(position,i);
            right=upperBound(position,j)-1;
            if(left<=right){
                int total=prefix[right]-(left>0 ? prefix[left-1]:0);
                maxFruit=Math.max(maxFruit,total);
            }
        }
        return maxFruit;
    }
}