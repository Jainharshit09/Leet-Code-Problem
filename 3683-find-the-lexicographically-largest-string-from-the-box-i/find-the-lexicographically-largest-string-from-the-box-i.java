class Solution {
    public String answerString(String word, int numFriends) {
        if(numFriends==1){
            return word;
        }
        int n=word.length();
        int task=n-(numFriends-1);
        String result="";
        for(int i=0;i<n;i++){
            int mini=Math.min(task,n-i);
            String substring=word.substring(i,i+mini);
            if (substring.compareTo(result) > 0) {
                result = substring;
            }
        }
        return result;
    }
}