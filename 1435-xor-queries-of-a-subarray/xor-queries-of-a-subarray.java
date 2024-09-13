class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = queries.length;
        int ans[] = new int[n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            int start=queries[i][0];
            int end=queries[i][1];
            int temp=0;
            for(int k=start;k<=end;k++){
                temp^=arr[k];
            }
            ans[index++]=temp;
        }
        return ans;
    }
}