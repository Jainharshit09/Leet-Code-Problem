// in which ans n/3*n/3
//sort the array
// then check nums[i+2]-nums[i]>k at that return empty array
// f**k easy question
class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n=nums.length;
        int result[][]=new int[n/3][3];
        Arrays.sort(nums);
        int index=0;
        for(int i=0;i<n;i+=3){
            if(nums[i+2]-nums[i]>k){
                return new int[0][0];
            }
            result[index++]=new int[]{nums[i], nums[i + 1], nums[i + 2]};
        }
        return result;
    }
}