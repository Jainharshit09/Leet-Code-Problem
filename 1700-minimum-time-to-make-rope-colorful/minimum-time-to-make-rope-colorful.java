class Solution {
    public int minCost(String colors, int[] neededTime) {
        int cost=0;
        int n=colors.length();
        int prev_time=neededTime[0];
        if(colors.length()==1)return 0;
        for(int i=1;i<n;i++){
            char prev=colors.charAt(i-1);
            char curr=colors.charAt(i);
            if(prev==curr){
                cost+=Math.min(neededTime[i],prev_time);
                prev_time=Math.max(neededTime[i],prev_time);
            }
            else{
                prev_time=neededTime[i];
            }
        }
        return cost;
    }
}