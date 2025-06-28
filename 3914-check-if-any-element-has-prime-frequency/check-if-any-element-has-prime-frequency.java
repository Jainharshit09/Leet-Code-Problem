class Solution {
    public boolean sieve(int n){
        boolean prime[]=new boolean[n+1];
           for (int i = 0; i <= n; i++) {
            prime[i] = true;
        }
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }
        return prime[n];
    }
    public boolean checkPrimeFrequency(int[] nums) {
        int freq[]=new int[101];
        int n=nums.length;
        for(int i=0;i<n;i++){
            freq[nums[i]]++;
        }
        for(int i=0;i<101;i++){
            int curr=freq[i];
            if(curr==0 || curr==1)continue;
            if(sieve(curr)==true)return true;
        }
        return false;
    }
}