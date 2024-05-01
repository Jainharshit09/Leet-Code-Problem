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
        int start=0;
        int end=-1;
        char [] chars=word.toCharArray();
        int n=chars.length;
        for(int i=0;i<n;i++){
            if(chars[i]==ch){
                end=i;
                // swap(chars,0,i);
               break;
            }
        }
        if(end==-1){
            return word;
        }
        while(start<end){
            char h=chars[start];
            chars[start]=chars[end];
           chars[end]=h;
            start++;
            end--;
        }
        return new String(chars);
    }
}