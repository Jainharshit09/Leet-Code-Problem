class Solution {
    public int maximumPossibleSize(int[] nums) {
        int n=nums.length-1;
        Stack<Integer>stack=new Stack<>();
        for(int i=n;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<nums[i]){
                stack.pop();
            }
            stack.push(nums[i]);
        }
        return stack.size();
    }
}