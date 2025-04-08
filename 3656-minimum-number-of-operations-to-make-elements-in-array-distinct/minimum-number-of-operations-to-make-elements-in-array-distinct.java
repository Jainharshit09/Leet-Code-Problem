class Solution {
    public boolean isUnique(int nums[],int start){
        Set<Integer>set=new HashSet<>();
        for(int i=start;i<nums.length;i++){
            if(set.contains(nums[i])){
                return false;
            }
            set.add(nums[i]);
        }
        return true;
    }
    public int minimumOperations(int[] nums) {
       int n=nums.length;
       int operation=0;
       for(int i=0;i<n;i+=3){
            if(isUnique(nums,i)){
                return operation;
            }
            operation++;
       }
       return operation;
    }
}