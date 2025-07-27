//given undirected tree
// no cycle  every node having unique or distinct distance
//so no means of shortest path
//now it is combination of dfs and segment
// we can precalculate dfs for every node 1 to x
// also create a intime and outime array and parent array
// now at the time of update using lazy delta we can update in that becuase if node edge is change it will effect it children also 
// at the time of finding the query getting either value of intime or outime add in precomputed ans
// this is my appoach to solve this question 
class Solution {
    HashMap<Integer, List<int[]>> adj;
    int[] inTime;
    int[] shortestDis;
    int[] outTime;
    int[] parent;
    int [] bit;
    int time = 1;
    Map<Long, Integer> edgeWeight = new HashMap<>();

      public void add(int i, int val) {
        while (i < bit.length) {
            bit[i] += val;
            i += i & -i;
        }
    }
       public int query(int i) {
        int sum = 0;
        while (i > 0) {
            sum += bit[i];
            i -= i & -i;
        }
        return sum;
    }

     public void rangeAdd(int l, int r, int val) {
        add(l, val);
        add(r + 1, -val);
    }

     public void updateQuery(int u, int v, int newWeight) {
        long key = ((long) Math.min(u, v) << 32) | Math.max(u, v);
        int oldWeight = edgeWeight.getOrDefault(key, 0);
        int delta = newWeight - oldWeight;

        edgeWeight.put(key, newWeight);

        // Find child in u-v
        int child = (parent[u] == v) ? u : v;

        add(inTime[child], delta);
        add(outTime[child], -delta);
    }

    //precompute the first all shortest between node1 to x
    public void dfs(int node, int p, int w) {
        inTime[node] = time;
        time++;
        parent[node] = p;
        shortestDis[node] = w;
        for (int[] ngbr : adj.get(node)) {
            int v = ngbr[0];
            int wt = ngbr[1];
            if (v != p) {
                dfs(v, node, w + wt);
            }
        }
        outTime[node] = time;
    }

    public int[] treeQueries(int n, int[][] edges, int[][] queries) {
        adj = new HashMap<>();
        shortestDis = new int[n + 1];
        inTime = new int[n + 1];
        outTime = new int[n + 1];
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int e[] : edges) {
            int u = e[0];
            int v = e[1];
            int wt = e[2];
            adj.get(u).add(new int[] { v, wt });
            adj.get(v).add(new int[] { u, wt });
            long key = ((long) Math.min(u, v) << 32) | Math.max(u, v);
             edgeWeight.put(key, wt); 
        }
        dfs(1, -1, 0);
        bit=new int[time+2];
        ArrayList<Integer>ans=new ArrayList<>();
        for(int q[]:queries){
            int id=q[0];
            if(id==1){
                updateQuery(q[1],q[2],q[3]);
            }
            else{
                int index=q[1];
                ans.add(shortestDis[index] + query(inTime[index]));
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}