class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n=nums.length;
        ArrayList<Integer>small=new ArrayList<>();
        ArrayList<Integer>large=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(nums[i]<pivot){
                small.add(nums[i]);
            }
            else if(nums[i]==pivot){
                large.add(0,nums[i]);
            }
            else{
                large.add(nums[i]);
            }
        }
        int ans[]=new int[n];
        small.addAll(large);
        for(int i=0;i<n;i++){
            ans[i]=small.get(i);
        }
        return ans;
    }
}