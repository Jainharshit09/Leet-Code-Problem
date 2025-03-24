class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings,Comparator.comparingInt(a -> a[0]));
        int prevTime=0;
        int ans=0;
        for(int[]meet:meetings){
            int start=meet[0];
            int end=meet[1];
            if(start>prevTime+1){
                ans+=start-prevTime-1;
            }
            prevTime=Math.max(prevTime,end);
        }
        ans+=days-prevTime;
        return ans;
    }
}