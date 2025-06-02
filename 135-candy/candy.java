class Solution {
    //solve in o(n) and o(1) not using store the candides rather we see if we peak and drop 
    public int candy(int[] rating) {
        int n=rating.length;
        int candy=n;
        int i=1;
        while(i<n){
            int peak=0;
            if(rating[i]==rating[i-1]){
                i++;
                continue;
            }
            while(rating[i]>rating[i-1]){
                peak++;
                i++;
                candy+=peak;
                if(i==n){
                    return candy;
                }
            }
            int dip=0;
            while(i<n && rating[i]<rating[i-1]){
                dip++;
                i++;
                candy+=dip;
            }
            //couting two times in increasing and decreasing of peak value
            candy-=Math.min(dip,peak);
        }
        return candy;
    }
}