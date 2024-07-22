class Pair implements Comparable<Pair>{
    int height;
    String name;
    public Pair(int height,String name){
        this.height=height;
        this.name=name;
    }
    public int compareTo(Pair p){
        return p.height-this.height;
    }
}
class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n=heights.length;
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            int h=heights[i];
            String name=names[i];
            pq.add(new Pair(h,name));
        }
       String ans[]=new String[n];
       int i=0;
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            String name=curr.name;
            ans[i++]=name;
        }
        return ans;
    }
}