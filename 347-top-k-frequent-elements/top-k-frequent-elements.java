//use hashmap to store the count
//after that take element having maximun count of top k will be added in pq and tracverse the pq and get the ans;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }  
        PriorityQueue<Integer>pq=new PriorityQueue<>(
             (a, b)-> map.get(a)-map.get(b)
        );
        for(int num:map.keySet()){
            pq.add(num);
            if(pq.size()>k)pq.poll();
        }
        int ans[]=new int [k];
        for(int i=0;i<k;i++){
            ans[i]=pq.poll();
        }
        return ans;
    }
}