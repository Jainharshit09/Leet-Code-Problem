class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer>map=new HashMap<>();
        int n=words.length;
        for(int i=0;i<n;i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        PriorityQueue<String>pq=new PriorityQueue<>(
            (a,b)-> map.get(a).equals(map.get(b)) ? b.compareTo(a) : map.get(a) - map.get(b)
        );
        for(String word:map.keySet()){
            pq.add(word);
            if(pq.size()>k)pq.poll();
        }
        List<String>ans=new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(0,pq.poll());
        }
        return ans;
    }
}