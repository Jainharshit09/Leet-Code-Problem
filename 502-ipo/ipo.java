class pair implements Comparable<pair>{
    int cap;
    int profit;
    public pair(int cap,int profit){
        this.cap=cap;
        this.profit=profit;
    }
    public int compareTo(pair p){
        return this.cap-p.cap;
    }
}
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
       ArrayList<pair> list=new ArrayList<>();
        for(int i=0;i<profits.length;i++){
            list.add(new pair(capital[i],profits[i]));
        }
        Collections.sort(list);
        PriorityQueue<Integer>heap = new PriorityQueue<>((a, b) -> b - a);
        int index=0;
        for(int i=0;i<k;i++){
            while(index<list.size()&& list.get(index).cap<=w){
                heap.add(list.get(index).profit);
                index++;
            }
             if (heap.isEmpty()) {
                break;
            }
             w += heap.poll();
        }
        return w;
    }
}