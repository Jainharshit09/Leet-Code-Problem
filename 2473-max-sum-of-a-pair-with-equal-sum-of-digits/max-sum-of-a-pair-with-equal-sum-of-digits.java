class Solution {
    public int find(int num){
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    public int maximumSum(int[] nums) {
        int n=nums.length;
        HashMap<Integer,PriorityQueue<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int sum=find(nums[i]);
            map.putIfAbsent(sum, new PriorityQueue<>());
            map.get(sum).add(nums[i]);
            if(map.get(sum).size()>2){
                      map.get(sum).poll();
            }
        }
        int ans=Integer.MIN_VALUE;
        for (PriorityQueue<Integer> pq : map.values()){
                if (pq.size() == 2) {
                int first = pq.poll();
                int second = pq.poll();
                ans = Math.max(ans, first + second);
            }
        }
        return ans == Integer.MIN_VALUE ? -1 : ans;
    }
}