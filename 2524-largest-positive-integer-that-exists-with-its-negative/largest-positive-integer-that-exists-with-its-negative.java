class Solution {
    public int findMaxK(int[] nums) {
        Set<Integer> map=new HashSet<>();
        int ans=-1;
        for(int i=0;i<nums.length;i++){
            if(map.contains(-(nums[i]))){
                int curr=Math.abs(nums[i]);
                ans=Math.max(ans,curr);
            }
            else{
                map.add(nums[i]);
            }
        }
        return ans;
    }
}