class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        List<Integer> list = new ArrayList<>();
        if (startTime[0] > 0) {
            list.add(startTime[0]);
        }
        for (int i = 0; i < n-1; i++) {
            list.add(startTime[i+1] - endTime[i]);
        }
        if (endTime[n - 1] < eventTime) {
            list.add(eventTime - endTime[n - 1]);
        }
        int ans=0,sum=0;
        for(int i=0;i<list.size();i++){
            sum+=list.get(i);
            ans=Math.max(ans,sum);
            if(i>=k){
                sum-=list.get(i-k);
            }
        }
        return ans;
    }
}