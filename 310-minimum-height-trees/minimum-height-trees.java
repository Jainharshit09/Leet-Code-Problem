class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
       ArrayList <Integer> ans=new ArrayList<>();
       if(n==1){
        ans.add(0);
        return ans;
       }
       int [] indegree=new int[n];
       Map<Integer,ArrayList<Integer>>adj =new HashMap<>();
       for(int edge[] : edges){
        int u=edge[0];
        int v=edge[1];
        indegree[u]++;
        indegree[v]++;
        adj.computeIfAbsent(u, k-> new ArrayList<>()).add(v);
         adj.computeIfAbsent(v, k-> new ArrayList<>()).add(u);}
         Queue<Integer> q=new LinkedList<>();
         for(int i=0;i<n;i++){
            if(indegree[i]==1){
                q.add(i);
            }
         }
         while(n>2){
            int size=q.size();
            n-=size;
            while(size-->0){
                int u=q.poll();
                for(int v : adj.get(u)){
                    indegree[v]--;
                    if(indegree[v]==1){
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