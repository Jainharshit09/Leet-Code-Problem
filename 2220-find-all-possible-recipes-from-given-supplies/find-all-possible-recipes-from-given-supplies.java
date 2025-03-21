class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n=recipes.length;
        List<String>ans=new ArrayList<>();
        int indegree[]=new int[n];
        Set<String>set=new HashSet<>();
        HashMap<String,ArrayList<Integer>>adj=new HashMap<>();
        for(int i=0;i<supplies.length;i++){
            set.add(supplies[i]);
        }
        for(int i=0;i<n;i++){
            for(String ing:ingredients.get(i)){
                if(!set.contains(ing)){
                    adj.putIfAbsent(ing, new ArrayList<>());
                    adj.get(ing).add(i);
                    indegree[i]++;
                }
            }
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty())
        {
            int curr=q.poll();
            String recipe=recipes[curr];
            ans.add(recipe);
            if(adj.containsKey(recipe)){
                for(int idx : adj.get(recipe)){
                    indegree[idx]--;
                    if(indegree[idx]==0){
                        q.add(idx);
                    }
                }
            }
        }
        return ans;
    }
}
