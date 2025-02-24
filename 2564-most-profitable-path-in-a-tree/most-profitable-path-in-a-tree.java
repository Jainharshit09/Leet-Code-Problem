class Solution {
     int aliceIncome;
    Map<Integer, List<Integer>> adj = new HashMap<>();
    Map<Integer, Integer> map = new HashMap<>();
    public boolean DFSBob(int curr,int time,boolean[] vis){
        vis[curr]=true;
        map.put(curr,time);
        if (curr == 0) { 
            return true;
        }
        for(int ngbr: adj.getOrDefault(curr, new ArrayList<>())){
            if(!vis[ngbr]){
                if(DFSBob(ngbr,time+1,vis)==true){
                    return true;
                   }
            }
        }
        map.remove(curr);
        return false;
    }
    void DFSAlice(int curr, int t, int income, boolean[] visited, int[] amount){
        visited[curr]=true;
        if(!map.containsKey(curr) || t < map.get(curr)){
             income += amount[curr];
        }
        else if(t==map.get(curr)){
            income += (amount[curr] / 2);
        }
        if (adj.getOrDefault(curr, new ArrayList<>()).size() == 1 && curr != 0) {
            aliceIncome = Math.max(aliceIncome, income);
        }
         for (int ngbr : adj.getOrDefault(curr, new ArrayList<>())) {
            if (!visited[ngbr]) {
                DFSAlice(ngbr, t + 1, income, visited, amount);
            }
        }
    }
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n=amount.length;
        aliceIncome=Integer.MIN_VALUE;
            for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        int time = 0;
        boolean[] visited = new boolean[n];
        DFSBob(bob, time, visited);

        int income=0;
        Arrays.fill(visited,false);
        DFSAlice(0,0,income,visited,amount);
        return aliceIncome;
    }
}