class Solution {
    public int findCenter(int[][] edges) {
        int ans[]=new int[edges.length+2];
       for(int []edge:edges){
        ans[edge[0]]++;
        ans[edge[1]]++;
       }
       for(int i=1;i<ans.length;i++){
        if(ans[i]==edges.length){
            return i;
        }
       }
       return -1;
    }
}