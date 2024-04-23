class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
       ArrayList <Integer> ans=new ArrayList<>();
        if (n == 1)
            return Collections.singletonList(0);
       int [] indgree=new int[n];
       Map<Integer,ArrayList<Integer>>adj =new HashMap<>();
       for(int edge[]:edges){
        int u = edge[0];
        int v = edge[1];
        indgree[u]++;
        indgree[v]++;
         adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
         adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
       }
       Queue <Integer> q= new LinkedList<>();
       for(int i=0;i<n;i++){
        if(indgree[i]==1){
            q.add(i);
        }
       }
       while(n>2){
        int size=q.size();
        n -= size;
        while(size-->0){
            int u=q.poll();
            for(int v: adj.get(u)){
                indgree[v]--;
                if(indgree[v]==1){
                    q.add(v);
                }
            }
        }
       }
       while(!q.isEmpty()){
        ans.add(q.poll());
       }
       return ans;
   }
} 