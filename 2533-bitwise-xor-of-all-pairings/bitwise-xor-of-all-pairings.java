class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int xor1=0,xor2=0;
        for(int num:nums1){
            xor1^=num;
        }
        for(int num:nums2){
            xor2^=num;
        }
        int result=0;
        if(m%2==1){
            result^=xor1;
        }
        if(n%2==1){
            result^=xor2;
        }
        return result;
    }
}