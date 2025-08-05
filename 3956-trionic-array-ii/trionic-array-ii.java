// give increasing than decreasing than again increasing
// need to find the maximun sum 
//l<p<q<r
//0,-2,-3,-6,-6,-4,-3 create a prefix sum array

// -2<-1 -1>-3  -3<0

// min 2 element each will  be there in l to p include and p to q and q to r
// brute force we can do like start with every index and check all three condition
// min 4 element to valid means in brute last n-4 we will go


// in prefix sum like sum will increase than decrease than again increase means at that position ans will be there

//[0,-2,-1,-3,2,-1]

//like having l=0; p=0;q=0;r=0;
//arr[i]<arr[i+1] if true than make l=1
// now check it statisfy the second l<p means l is there if yes than add in p
// similar we can do q and r if any breakout come then all are one means we find first subarray by using prefix sum array having l and r index do subrtact and try on new array

//like there is choice we can do using dp
//like one is previosuly taking or not or dp[index][0/1/2][0/1]
// means question using 3dp and in which 0/1/2 represent the 0increasing 1 decreasing 2 increasing that all three condition we are having


//like getting increasing than having choice continue or go with new subarray
// in decresing like continue decresaing and suddenly get increasing means go with 0 means at positoin possible we get another good array
//same in increasing again

//like in incresing getting suddenly decrease than call phase 1 and in phase 1 suddenly get increasing call 2 and 0 

//in same getting incresing continue and getting decreasing than go with phase 1


class Solution {
    int n;
    Long dp[][][];
    public long solve(int nums[],int phase,int i,boolean started){
        if(phase==3)return 0;
        if(i==n) return -1000000000000000L;
        long res = -1000000000000000L;
        int startedFlag=started?1:0;
         if (dp[phase][i][startedFlag] != null) {
            return dp[phase][i][startedFlag];
        }
        if(!started){
            res=Math.max(res,solve(nums,phase,i+1,false));//skip current element and move on
            res=Math.max(res,solve(nums,phase,i+1,true)+nums[i]); //include new element start a new subarry
        }
        else{
            if(phase==0 && nums[i]>nums[i-1]){
                res=Math.max(res,solve(nums,phase,i+1,true)+nums[i]); // increasing continue
                res=Math.max(res,solve(nums,phase+1,i+1,true)+nums[i]);  // Transition to phase 1
            }
            if(phase==1 && nums[i]<nums[i-1]){
                res=Math.max(res,solve(nums,phase,i+1,true)+nums[i]);//decreasing continue
                res=Math.max(res,solve(nums,phase+1,i+1,true)+nums[i]); // // Transition to phase 2
            }
            if(phase==2 && nums[i]>nums[i-1]){
                res=Math.max(res,solve(nums,phase,i+1,true)+nums[i]); // increasing continue
                res=Math.max(res,solve(nums,phase+1,i+1,true)+nums[i]); // // Transition to phase 3 the last we get
            }
        }
         return dp[phase][i][startedFlag] = res;
    }
    public long maxSumTrionic(int[] nums) {
        n=nums.length;
        dp=new Long[4][n][2];

        return solve(nums,0,0,false);
    }
}