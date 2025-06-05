class Solution {
    // create a grpah then do a basic dfs
    // in dfs only need to find the min character 
    public char dfs(HashMap<Character,List<Character>>adj,char curr_ch,boolean vis[]){
        vis[curr_ch-'a']=true;
        char ans=curr_ch;
        for(char ngbr:adj.getOrDefault(curr_ch,new ArrayList<>())){
            if(!vis[ngbr-'a']){
                char temp=dfs(adj,ngbr,vis);
                if(ans>temp){
                ans=temp;
            }

            }
            
        }
        return ans;
    }
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n=s1.length();
        HashMap<Character,List<Character>>adj=new HashMap<>();
        for(int i=0;i<n;i++){
            char u=s1.charAt(i);
            char v=s2.charAt(i);
            //creating a undirected graph
            adj.putIfAbsent(u,new ArrayList<>());
            adj.putIfAbsent(v,new ArrayList<>());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        StringBuilder result=new StringBuilder();
        for(int i=0;i<baseStr.length();i++){
            boolean vis[]=new boolean[26];
            //dfs will find the min charater for that current character
            char temp=dfs(adj,baseStr.charAt(i),vis);
            result.append(temp);
        }
        return result.toString();
    }
}