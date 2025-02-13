class Solution {
    public int minOperations(int[] nums, int k) {
        int ans=0;
        PriorityQueue<Long>pq=new PriorityQueue<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            pq.add((long)(nums[i]));
        }
        while(!pq.isEmpty() && pq.peek()<k && pq.size()>=2){
            long first=pq.poll();
            long second=pq.poll();
            long value=Math.min(first,second)*2+Math.max(first,second);
            ans++;
            pq.add(value);
        }
        return ans;
    }
}