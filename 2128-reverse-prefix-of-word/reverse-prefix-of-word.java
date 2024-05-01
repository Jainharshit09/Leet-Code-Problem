class Solution {
    public void swap(char[] word,int start,int end){
        while(start<end){
            char ch=word[start];
            word[start]=word[end];
           word[end]=ch;
            start++;
            end--;
        }
    }
    public String reversePrefix(String word, char ch) {
        char [] chars=word.toCharArray();
        int n=chars.length;
        for(int i=0;i<n;i++){
            if(chars[i]==ch){
                swap(chars,0,i);
               break;
            }
        }
        return new String(chars);
    }
}