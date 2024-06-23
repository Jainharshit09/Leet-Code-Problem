class Pair{
    int ind;
    int value;
    public Pair(int ind,int value){
        this.ind=ind;
        this.value=value;
    }
}
class Solution {
    public int longestSubarray(int[] nums, int limit) {
       int ans=0;
      PriorityQueue<Pair> pq_min = new PriorityQueue<>((a, b) -> Integer.compare(a.value, b.value));
       PriorityQueue<Pair> pq_max = new PriorityQueue<>((a, b) -> b.value - a.value);
       int i=0;
      for(int j=0;j<nums.length;j++){
        pq_min.add(new Pair(j,nums[j]));
        pq_max.add(new Pair(j,nums[j]));
       int min=pq_min.peek().value;
       int max=pq_max.peek().value;
         while(max-min>limit){
            i++;
            while(pq_max.peek().ind< i){
                pq_max.poll();
            }
            while (pq_min.peek().ind < i) {
                    pq_min.poll();
                }
             min = pq_min.peek().value;
             max = pq_max.peek().value;
         }
         ans=Math.max(ans,j-i+1);
       }
       return ans;
    }
}