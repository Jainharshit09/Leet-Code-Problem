class Solution {
    public boolean isToeplitzMatrix(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        boolean ans=false;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i-1>=0 && j-1>=0 && arr[i][j]!=arr[i-1][j-1]){
                    return false;
                }
            }
        }
        return true;
    }
}