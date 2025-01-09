class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder ans=new StringBuilder();
        while(columnNumber>0){
            columnNumber--;
            char idx=(char)((columnNumber%26)+'A');
            ans.append(idx);
            columnNumber/=26;
        }
        return ans.reverse().toString();
    }
}