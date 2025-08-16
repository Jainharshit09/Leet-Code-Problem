//find the perfect pairs
//make sure i<j
// from 2 conditon min(|a - b|, |a + b|) <= min(|a|, |b|)
// and max(|a - b|, |a + b|) >= max(|a|, |b|)
//like brute question saying going toward focus on question but get tle in that case 
//ans  will be long
//can sorting will work there
// like if number is negative than both than min will fail the max will satsify
// a=7 and b=-2 than a+b<=-b a<=-2b
//|a| <=2*|b| if a>b basically max<=2*min

class Solution {
    public long perfectPairs(int[] nums) {
        long ans=0;
        for(int i=0;i<nums.length;i++){
            nums[i]=Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        for(int i=0,j=0;j<nums.length;j++){
             while (i <= j && nums[j] > 2 * nums[i]) i++;
             ans+=j-i;
        }
        return ans;
    }
}