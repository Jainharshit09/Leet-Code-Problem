class Solution {
    public boolean isCircularSentence(String s){
        String[] words = s.split(" ");
        if (words.length == 1) {
            return words[0].charAt(0) == words[0].charAt(words[0].length() - 1);
        }
        int first=words[0].charAt(0);
        int last=words[0].charAt(words[0].length() - 1);
        for(int i=1;i<words.length;i++){
            if (words[i].charAt(0) != last) {
                return false;
            }
            last = words[i].charAt(words[i].length() - 1);
        }
         return first == last;
    }
}