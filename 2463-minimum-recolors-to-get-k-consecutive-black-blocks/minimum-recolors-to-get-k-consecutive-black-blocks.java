class Solution {
    public int minimumRecolors(String s, int k) {
        int i=0;
        int j=0;
        int whiteCount=0;
        int ans=Integer.MAX_VALUE;
        int n=s.length();
        while(j<n){
            char ch=s.charAt(j);
            if(ch=='W'){whiteCount++;}
            if(j-i+1==k){
                ans=Math.min(whiteCount,ans);
                if(s.charAt(i)=='W'){
                    whiteCount--;
                }
                i++;
            }
            j++;
        }
        return ans;
    }
}