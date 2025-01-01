class Solution {
    public int solve(int img[][],int x,int y,int n,int m){
        int sum=0;
        int count=0;
        for(int i=x-1;i<=x+1;i++){
            for(int j=y-1;j<=y+1;j++){
                if(0<=i && i<n && 0<=j && j<m){
                    sum+=img[i][j];
                    count++;
                }
            }
        }
        return sum/count;
    }
    public int[][] imageSmoother(int[][] img) {
        int n=img.length;
        int m=img[0].length;
        int ans[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans[i][j]=solve(img,i,j,n,m);
            }
        }
        return ans;
    }
}