class Solution {
    public int maxScore(String s) {
        int n=s.length();
        int ans=Integer.MIN_VALUE;
        int ones=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)-'0'==1){
                ones++;
            }
        }
        int zero=0;
        for(int i=0;i<n-1;i++){
             if(s.charAt(i)-'0'==0){
                zero++;
             }
             else{
                ones--;
             }
              ans=Math.max(ans,zero+ones);
        }
        return ans;
    }
}