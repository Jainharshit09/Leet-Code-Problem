//basic recursion like take or skip but gettig tle
// move towards the dp getting tle again
//now move more optimize  with bs on finding next i in take
class Solution {
    int n;
    int dp[][];

     private int findNext(int[][] events, int currentEnd, int low) {
        int high = events.length - 1;
        int ans = events.length;  // Default: no event found
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (events[mid][0] > currentEnd) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    public int solve(int [][] events,int i,int k){
        if(i>=n || k==0)return 0;
        if(dp[i][k]!=-1)return dp[i][k];
        int skip=solve(events,i+1,k);
        int j=findNext(events, events[i][1], i + 1);
        int take=events[i][2]+solve(events,j,k-1);
        return dp[i][k]= Math.max(take,skip);
    }
    public int maxValue(int[][] events, int k) {
        n=events.length;
        dp=new int[n+1][k+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        Arrays.sort(events,(a,b)->Integer.compare(a[0],b[0]));
        return solve(events,0,k);
    }
}