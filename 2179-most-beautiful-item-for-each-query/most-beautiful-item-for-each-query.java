class Solution {
    public int binary(int arr[][],int price){
        int l=0;
        int r=arr.length-1;
        int maxBeauty = 0;
        while(l<=r){
             int mid=l+(r-l)/2;
             if (arr[mid][0]>price){
                r=mid-1;
             }
             else{
                maxBeauty = Math.max(maxBeauty, arr[mid][1]);
                l=mid+1;
             }
        }
        return maxBeauty;
    }
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> Integer.compare(a[0], b[0]));
        int n = items.length;
        int m = queries.length;
        int[] result = new int[m];
        int maxi=items[0][1];
        for(int i=1;i<n;i++){
            maxi=Math.max(items[i][1],maxi);
            items[i][1]=maxi;
        }
        for(int i=0;i<m;i++){
            int price=queries[i];
            result[i]=binary(items,price);
        }
        return result;
    }
}