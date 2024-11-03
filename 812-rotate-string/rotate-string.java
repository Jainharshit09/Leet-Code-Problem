class Solution {
    public boolean rotateString(String s, String goal) {
        int n=s.length();
        int m=goal.length();
        if(n!=m){
            return false;
        }
        if(n==m && (s+s).contains(goal)){
            return true;
        }
        return false;
    }
}