class Solution {
    public void dfs(int curr,Map<Integer, List<Integer>> adj,int mark[],int parent,int count[]){
        if(mark[curr]==0){
            count[0]++;
        }
        else{
            count[1]++;
        }
        for(int ngbr:adj.getOrDefault(curr,new ArrayList<>())){
            if(parent!=ngbr){
                mark[ngbr]=(mark[curr] == 0) ? 1 : 0;
                dfs(ngbr,adj,mark,curr,count);
            }
        }
    }
     public Map<Integer, List<Integer>> getAdj(int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.putIfAbsent(u, new ArrayList<>());
            adj.putIfAbsent(v, new ArrayList<>());

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return adj;
    }
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n=edges1.length+1;
        int m=edges2.length+1;
        Map<Integer, List<Integer>> adjA=getAdj(edges1);
        Map<Integer, List<Integer>> adjB=getAdj(edges2);

        int markA[]=new int[n];
        Arrays.fill(markA, -1);
        markA[0] = 0;
        int[] countA = new int[2];
        dfs(0,adjA,markA,-1,countA);

        int markB[]=new int[m];
        Arrays.fill(markB, -1);
        markB[0] = 0;
        int[] countB = new int[2];
        dfs(0,adjB,markB,-1,countB);
        int maxFromTree2 = Math.max(countB[0], countB[1]);
        int result[]=new int [n];
        for(int i=0;i<n;i++){
            result[i]=(markA[i] == 0 ? countA[0]:countA[1])+maxFromTree2;
        }
        return result;
    }
}