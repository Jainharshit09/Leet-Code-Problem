class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int indegree[]=new int [n];
        for(int[]road:roads){
            indegree[road[0]]++;
            indegree[road[1]]++;
        }
        Integer[]city=new Integer[n];
        for(int i=0;i<n;i++){
            city[i]=i;
        }
        Arrays.sort(city,(a, b) -> indegree[b] - indegree[a]);
        int count[]=new int[n];
        int k=n;
        for(int citi:city){
            count[citi]=k--;
        }
        long ans=0;
        for(int []road:roads){
            ans+=count[road[0]]+count[road[1]];
        }
        return ans;
    }
}