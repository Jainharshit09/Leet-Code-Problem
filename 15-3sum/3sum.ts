function threeSum(nums: number[]): number[][] {
     nums.sort((a, b) => a - b); 
    let ans: number[][] = [];
    let n=nums.length;
    if(n==0 || n<3){
        return ans;
    }
    for(let i=0;i<n-2;i++){
         if (i > 0 && nums[i] === nums[i - 1]) continue;
        let start=i+1;
        let end=n-1;
        while(start<end){
            let sum=nums[i]+nums[start]+nums[end];
            if(sum===0){
                ans.push([nums[i],nums[start],nums[end]]);
                start++;
                end--;
                while(start<end && nums[start]==nums[start-1]){start++;}
                while(start<end && nums[end]==nums[end+1]){end--;}

            }
            else if(sum<0){
                start++;
            }
            else{
                end--;
            }
        }
    }
    return ans;
};