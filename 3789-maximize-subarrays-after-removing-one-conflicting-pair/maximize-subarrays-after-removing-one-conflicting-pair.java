class Solution {
    public long maxSubarrays(int n, int[][] conflictingPairs) {
        long valid=0;
         List<List<Integer>> conflictingPoints = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            conflictingPoints.add(new ArrayList<>());
        }
        //always make a small than b
        for(int [] arr:conflictingPairs){
            int a=Math.min(arr[0],arr[1]);
            int b=Math.max(arr[0],arr[1]);
            conflictingPoints.get(b).add(a);
        }

        int maxConflict=0;
        int secondMaxConflict=0;
        long[] extra = new long[n + 1];
        for(int end=1;end<=n;end++){
             for (int u : conflictingPoints.get(end)){
                //check all conflictingPoint find the max and second max
                if(u>=maxConflict){
                    secondMaxConflict=maxConflict;
                    maxConflict=u;
                }
                else if(u>secondMaxConflict){
                    secondMaxConflict=u;
                }
             }
             valid+=end-maxConflict;
             extra[maxConflict]+=maxConflict-secondMaxConflict;
        }
        long maxExtra = 0;
        for (long val : extra) {
            if (val > maxExtra) {
                maxExtra = val;
            }
        }
        return valid+maxExtra;
    }
}