class Solution {
    public boolean isPalindrome(String s, int start, int end){
        while (start<end) {
            if (s.charAt(start)!=s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public String solve(String s,int end){
        if (end<0) {
            return "";
        }
        if(isPalindrome(s,0,end)){
            String toAdd = s.substring(end+1);
            String reversedToAdd=new StringBuilder(toAdd).reverse().toString();
            return reversedToAdd+s;
        }
        return solve(s,end-1);
    }
    public String shortestPalindrome(String s) {
        if(s==null || s.isEmpty()){
            return s;
        }
        return solve(s, s.length() - 1);
    }
}