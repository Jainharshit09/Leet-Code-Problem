class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double result[]=new double[n];
        result[start_node]=1.0;
        for(int i=0;i<n-1;i++){
            boolean update=false;
            for(int j=0;j<edges.length;j++){
                int u=edges[j][0];
                int v=edges[j][1];
                double wt=succProb[j];
                if(result[u]*wt>result[v]){
                    update=true;
                    result[v]=result[u]*wt;
                }
                if(result[v]*wt>result[u]){
                    update=true;
                    result[u]=result[v]*wt;
                }
            }
            if(!update){
               break;
            }
        }
        return result[end_node];
    }
}