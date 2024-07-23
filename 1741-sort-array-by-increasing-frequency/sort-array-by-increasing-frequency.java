class Pair implements Comparable<Pair>{
    int no;
    int freq;
    public Pair(int no,int freq){
        this.no=no;
        this.freq=freq;
    }
    public int compareTo(Pair p){
          if (this.freq == p.freq) {
            return p.no - this.no;
        }
        return this.freq - p.freq;
    }  
}
class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }
            else{
                map.put(nums[i],1);
            }
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>();
       for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.add(new Pair(entry.getKey(), entry.getValue()));
        }
        int ans[]=new int[nums.length];
        int index=0;
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            for(int i=0;i<curr.freq;i++){
                ans[index++]=curr.no;
            }
        }
        return ans;
    }
}