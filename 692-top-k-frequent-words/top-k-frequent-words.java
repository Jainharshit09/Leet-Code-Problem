class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map=new HashMap<>();
        int n=words.length;
        for(int i=0;i<n;i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>(
            (a, b) -> map.get(a).equals(map.get(b)) ? a.compareTo(b) : map.get(b) - map.get(a)
        );
        List<String> list=new ArrayList<>(); 
        pq.addAll(map.keySet());
        while(k-->0){
            String ch=pq.remove();
            list.add(ch);
        }
        return list;
    }
}