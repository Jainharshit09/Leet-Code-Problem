class Solution {
    public boolean canConstruct(String s, int k) {
        int n=s.length();
        if(n<k){
            return false;
        }
        if(n==k){
            return true;
        }
        int odd_count=0;
        for(char ch:s.toCharArray()){
            odd_count^=1<<(ch-'a');
        }
         return Integer.bitCount(odd_count) <= k;
    }
}