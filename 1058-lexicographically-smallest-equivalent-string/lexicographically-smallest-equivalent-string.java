class Solution {
    class union{
        private int parent[];
        public union(int n){
            parent =new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
        }
        public int find(int x){
            if(parent[x]==x){
                return x;
            }
            return find(parent[x]);
        }
        public void union(int x,int y){
            int rootX=find(x);
            int rootY=find(y);
            if(rootX!=rootY){
                if(rootX<rootY){
                    parent[rootY]=rootX;
                }
                else{
                    parent[rootX]=rootY;
                }
            }
        }
    }
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        union union=new union(26);
        for(int i=0;i<s1.length();i++){
            char ch1=s1.charAt(i);
            char ch2=s2.charAt(i);
            union.union(ch1-'a',ch2-'a');
        }
        StringBuilder result=new StringBuilder();
        for(int i=0;i<baseStr.length();i++){
            char ch=baseStr.charAt(i);
            result.append((char)(union.find(ch-'a')+'a'));
        }
        return result.toString();
    }
}