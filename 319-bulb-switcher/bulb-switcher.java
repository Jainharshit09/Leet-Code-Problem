class Solution {
    public int bulbSwitch(int n) {
        int ans=1;
        int count=0;
        while(ans*ans<=n){
            count++;
            ans++;
        }
        return count;
    }
}