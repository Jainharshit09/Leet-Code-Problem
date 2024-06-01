class Solution {
    public int scoreOfString(String s) {
        int k=s.length();
        int n=0;
        for(int i=1;i<k;i++){
            n+=Math.abs(s.charAt(i)-s.charAt(i-1)); 
        }
        return n;
    }
}