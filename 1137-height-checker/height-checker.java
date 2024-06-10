class Solution {
    public int heightChecker(int[] height) {
        int ans=0;
        int arr[]=new int[height.length];
        for(int i=0;i<arr.length;i++){
            arr[i]=height[i];
        }
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=height[i]){
                ans++;
            }
        }
        return ans;
    }
}