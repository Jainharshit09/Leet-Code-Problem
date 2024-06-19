class Solution {
    public boolean possible(int []arr,int day,int m,int k){
        int cnt=0;
        int bqt=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=day){
                cnt++;
            }
            else{
                bqt+=cnt/k;
                cnt=0;
            }
        }
        bqt+=cnt/k;
        return bqt>=m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        long n=(long)m*(long)k;
        if(n>bloomDay.length){
            return -1;
        }
        int l=Integer.MAX_VALUE;
        int h=Integer.MIN_VALUE;
        for(int i=0;i<bloomDay.length;i++){
            l=Math.min(bloomDay[i],l);
            h=Math.max(bloomDay[i],h);
        }
        int low=l;
        int high=h;
        while(low<high){
            int mid=low+(high-low)/2;
            if(possible(bloomDay,mid,m,k)){
                high=mid;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}