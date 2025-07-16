//only remember any time given equation do observation on it 
//in that even+even=even and same odd+odd=even
//for odd either one is even and other is odd 
// taking there count and return max of all that
class Solution {
    public int maximumLength(int[] nums) {
        int n=nums.length;
        int even=0;
        int odd=0;
        int alt=0;
        int parity=nums[0]%2;
        for(int i=0;i<n;i++){
            if(nums[i]%2==0){
                even++;
            }
            if(nums[i]%2!=0){
                odd++;
            }
            if(nums[i]%2==parity){
                alt++;
                parity^=1;
            }
        }
        return Math.max(even,Math.max(alt,odd));
    }
}