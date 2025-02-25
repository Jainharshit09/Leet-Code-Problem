class Solution {
    public int numOfSubarrays(int[] arr) {
        final int MOD = (int) (1e9 + 7);
        int sum=0;
        int even=1;
        int odd=0;
        int count=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum%2==0){
                count=(count+odd)%MOD;
                even++;
            }
            else{
                count=(count+even)%MOD;
                odd++;
            }
        }
        return count;
    }
}