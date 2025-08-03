//find the count of max balanced ship
// where max element is strictly less 

class Solution {
    public int maxBalancedShipments(int[] weight) {
        int maxi=Integer.MIN_VALUE;
        int n=weight.length;
        int ans=0;
        for(int x:weight){
            if(maxi>x){
                ans++;
                maxi=Integer.MIN_VALUE;
                continue;
            }
            maxi=Math.max(x,maxi);
        }
        return ans;
    }
}