class Solution {
    public String compressedString(String word) {
        StringBuilder ans=new  StringBuilder();
        int n=word.length();
        if(n==1){
            char ch=word.charAt(0);
             ans.append("1").append(ch);
            return ans.toString();
        }
        int i=0;
        int j=0;
        while(j<n){
             char ch = word.charAt(i);
            int count = 0;
            while (j < n && word.charAt(i) == word.charAt(j)) {
                count++;
                j++;
            }
             while (count > 9) {
                ans.append("9").append(ch);
                count -= 9;
            }
            if (count > 0) {
                ans.append(count).append(ch);
            }
            i = j;
        }
        return ans.toString();
    }
}