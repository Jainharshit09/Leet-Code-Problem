class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int ans[] = new int[n];
        int cumulative=0;
        int sum=0;
        for(int i=0;i<n;i++){
            ans[i]=sum;
            cumulative+=boxes.charAt(i) == '0' ? 0 : 1;
            sum+=cumulative;
        }
        sum=0;
        cumulative=0;
        for(int i=n-1;i>=0;i--){
            ans[i]+=sum;
            cumulative+=boxes.charAt(i) == '0' ? 0 : 1;
            sum+=cumulative;
        }
        return ans;
    }
}