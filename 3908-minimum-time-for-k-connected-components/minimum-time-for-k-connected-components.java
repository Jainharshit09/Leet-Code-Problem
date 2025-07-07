// we need k node 
// given edges (und) and nodes (0 -> n - 1)
// with time <= t, graph contains atleast k connected comps
// rather than deleting we can adding like in reverse order


//Process
// in dsu at the time we adding give me count and check

//Approch
// sort the array on the basis highest edges first
// create a dsu with all nodes are spreated components first
//Repetadely add the edges
//dsu cc<k than the time at this point is ans
//dsu cc>=k than ans will be zero   
class DSU{
    int parent[];
    public DSU(int n){
        parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
    }
        public int find(int x){
            if(parent[x]==x)return x;
            return parent[x]=find(parent[x]);
        }
        public boolean union(int x ,int y){
            int new_x=find(x);
            int new_y=find(y);
            if(new_x!=new_y){
                parent[new_x]=new_y;
                return true;
            }
            return false;
        }
}
class Solution {
    public int minTime(int n, int[][] edges, int k) {
        if(edges.length==0){
            return 0;
        }
        Arrays.sort(edges,(a,b)->Integer.compare(b[2],a[2]));
        DSU root=new DSU(n);
        int count=n;
        for(int edge[]:edges){
            int u=edge[0];
            int v=edge[1];
            int time=edge[2];
            if(root.union(u,v)){
                count--;
            }
            if(count<k){
                return time;
            }
        }
        return 0;
    }
}  