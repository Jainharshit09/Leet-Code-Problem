class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = queries.length;
        int ans[]=new int [arr.length];
        ans[0]=arr[0];
        for(int i =1;i<arr.length;i++){
            ans[i]=ans[i-1]^arr[i];
        }
        int result[]=new int [n];
        for(int i=0;i<n;i++){
            int start=queries[i][0];
            int end=queries[i][1];
            if(start==0){
                result[i]=ans[end];
            }
            else{
                result[i]=ans[end]^ans[start-1];
            }
        }
        return result;
    }
}