class Solution {
    public boolean divideArray(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                count++;
                map.remove(nums[i]);
            }
            else{
                map.put(nums[i],1);
            }
        }
        if(count==nums.length/2){
            return true;
        }
        return false;
    }
}