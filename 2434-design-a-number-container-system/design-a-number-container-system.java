class NumberContainers {
    HashMap<Integer,Integer>store;
    HashMap<Integer,PriorityQueue<Integer>>min_store;


    public NumberContainers() {
        store=new HashMap<>();
        min_store =new HashMap<>();
    }
    
    public void change(int index, int number) {
        store.put(index,number);
        min_store.computeIfAbsent(number, k -> new PriorityQueue<>()).add(index);
    }
    
    public int find(int number) {
        if(!min_store.containsKey(number)){
            return -1;
        }
        PriorityQueue<Integer>pq=min_store.get(number);
        while(!pq.isEmpty()){
            int index=pq.peek();
            if(store.get(index)==number){
                return index;
            }
            pq.poll();
        }
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */