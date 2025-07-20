class Solution {
    public boolean isPrime(int n){
        if(n<2){
            return false;
        }
        for(int i=2;i*i<=n;i++){
            if(n%i==0)return false;
        }

        return true;
    }
    public long splitArray(int[] nums) {
        long prime=0;
        long noPrime=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(isPrime(i))prime+=nums[i];
            else{
                noPrime+=nums[i];
            }
        }
        return Math.abs(prime-noPrime);
    }
}