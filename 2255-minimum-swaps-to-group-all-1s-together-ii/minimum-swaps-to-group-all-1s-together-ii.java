class Solution {
    public int minSwaps(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                k++;
            }
        }
        if(k==0 || k==1){
            return 0;
        }
        int temp[]=new int[2*nums.length];
        for(int i=0;i<2*nums.length;i++){
            temp[i]=nums[i%nums.length];
        }
        int j=0;
        int i=0;
        int maxCount=0;
        int count=0;
        while(j<2*nums.length){
            if(temp[j]==1){
                count++;
            }
            if(j-i+1<k){
                j++;
            }
            else if(j-i+1==k){
                maxCount=Math.max(count,maxCount);
                if(temp[i]==1){
                    count--;
                }
                i++;
                j++;
            }
        }
        return k-maxCount;
    }
}