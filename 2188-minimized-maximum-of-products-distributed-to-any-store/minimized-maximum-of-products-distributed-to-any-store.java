class Solution {
    public boolean solve(int mid,int arr[],int n){
        for(int a:arr){
            n -= (int) Math.ceil((double) a / mid);
            if(n<0){
                return false;
            }
        }
        return true;
    }
    public int minimizedMaximum(int n, int[] quantities) {
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<quantities.length;i++){
            maxi=Math.max(quantities[i],maxi);
        }
        int l=1;
        int r=maxi;
       int result=0;
       while(l<=r){
        int mid=l+(r-l)/2;
        if(solve(mid,quantities,n)){
             result=mid;
             r=mid-1;
        }
        else{
            l=mid+1;
        }
       }
       return result;
    }
}