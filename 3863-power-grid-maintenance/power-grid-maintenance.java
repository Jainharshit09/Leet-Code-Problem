//this question toward the connected components
// make sure in tht hashmap integer,Treeset we can use
// after that set will be in sorted order
// create a ans of c+1 and check that if index is true directly add in ans
// otherwise traverse from starting and make which one is true
// if query start with 2 make false
class DSU{
    int parent[];
    public DSU(int n){
        parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
    }
    public int find(int x){
        if(parent[x]!=x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    public void union(int x,int y){
        int new_x=find(x);
        int new_y=find(y);
        if(new_x!=new_y){
            parent[new_y]=new_x;
        }
    }
}
class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        HashMap<Integer,TreeSet<Integer>>adj=new HashMap<>();
        boolean check[]=new boolean[c+1];
        Arrays.fill(check,true);
        DSU root=new DSU(c+1);
        for(int edge[]:connections){
            root.union(edge[0],edge[1]);
        }
        for(int i=1;i<=c;i++){
            int parent=root.find(i);
            adj.putIfAbsent(parent, new TreeSet<>());
            adj.get(parent).add(i);
        }
        ArrayList<Integer>list=new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            int type=queries[i][0];
            int node=queries[i][1];
            if(type==1){
                if(check[node]==true)list.add(node);
                else{
                    //finding parent of that node and smallest one from that
                    int parent=root.find(node);
                    TreeSet<Integer>set=adj.get(parent);
                    list.add(set.isEmpty()? -1 : set.first());
                }
            }
            else{
                if(check[node]==true){
                    check[node]=false;
                    int parent=root.find(node);
                    adj.get(parent).remove(node);
                }

            }
        }
        int ans[]=new int[list.size()];
        for(int i=0;i<list.size();i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
}