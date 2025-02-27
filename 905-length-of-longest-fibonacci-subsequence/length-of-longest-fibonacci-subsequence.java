class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n=arr.length;
         int dp[][]=new int[n][n];
         HashMap<Integer,Integer>map=new HashMap<>();
         for(int i=0;i<n;i++){
            map.put(arr[i],i);
         }
          int max_length = 0;
         for (int[] row : dp) Arrays.fill(row, 2);
         for(int j=1;j<n;j++){
            for(int k=j+1;k<n;k++){
                 int target = arr[k] - arr[j];
                  if (map.containsKey(target) && map.get(target) < j){
                    int i=map.get(target);
                    dp[j][k]=dp[i][j]+1;
                  }
                 max_length=Math.max(max_length,dp[j][k]);
            }
         }
        return max_length >= 3 ? max_length : 0;
    }
}