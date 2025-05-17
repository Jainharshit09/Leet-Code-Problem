class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int one=0;
        int two=0;
        int zero=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                zero++;
            }
            if(nums[i]==1){
                one++;
            }
            if(nums[i]==2){
                two++;
            }
        }
        int index=0;
         if(zero!=0){
            while(zero>0){
                nums[index]=0;
                zero--;
                index++;
            }
        }
        if(one!=0){
            while(one>0){
                nums[index]=1;
                one--;
                index++;
            }
        }
         if(two!=0){
            while(two>0){
                nums[index]=2;
                two--;
                index++;
            }
        }
    }
}