class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n=queries.length;
        HashMap<Integer,Integer>vis=new HashMap<>();
        HashMap<Integer,Integer>color=new HashMap<>();
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            int index=queries[i][0];
            int colors=queries[i][1];
            if(!vis.containsKey(index)){
                vis.put(index,colors);
                color.put(colors,color.getOrDefault(colors,0)+1);
            }
            else{
                int color_index=vis.get(index);
                color.put(color_index,color.getOrDefault(color_index,0)-1);
                if(color.get(color_index)<=0){
                    color.remove(color_index);
                }
                color.put(colors,color.getOrDefault(colors,0)+1);
                vis.put(index,colors);
            }
            ans[i]=color.size();
        }
        return ans;
    }
}