//observation
//in mid there will decresaing order
// 0 to mid will be increasing order inclusive 
// mid to end increasing order inclusive
//both p and q are different 
// if all possible than ans will be true
//otherwise false;
class Solution {
    public boolean isIncrease(int nums[],int start,int end){
        for(int i=start;i<end;i++){
            if(nums[i]>=nums[i+1])return false;
        }
        return true;
    }
     public boolean isDecrease(int nums[],int start,int end){
        for(int i=start;i<end;i++){
            if(nums[i]<=nums[i+1])return false;
        }
        return true;
    }
    public boolean isTrionic(int[] nums) {
        int n=nums.length;
        if(n<3)return false;
        for(int p=1;p<n-2;p++){
            if(!isIncrease(nums,0,p))continue;
            for(int q=p+1;q<n-1;q++){
                 if(!isDecrease(nums,p,q))continue;
                 if(isIncrease(nums,q,n-1))return true;
            }
        }
        return false;
    }
}