//finding the k size window and max element
// for making k size use silding window
// for max element we use deque compare with last element and check is curr is bigger remove that 
// add in deque
//if match remove from front
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int n=nums.length;
        int ans[]=new int[n-k+1];
        int i=0,j=0,index=0;
        while(j<n){
            while(!dq.isEmpty() && nums[j]>dq.peekLast()){
                dq.pollLast(); 
            }
            dq.add(nums[j]);
            if(j-i+1==k){
                ans[index++]=dq.peek();
                if(nums[i]==dq.peek()){
                    dq.poll();
                }
                i++;
            }
            j++;
        }
        return ans;
    }
}