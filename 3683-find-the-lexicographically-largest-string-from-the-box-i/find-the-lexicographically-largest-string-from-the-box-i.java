class Solution {
    // rather than finding max then store and do for all index we can find the maxlength using n-(numFriends-1) then do for every index not on ma character find subtring word.substring(i,i+mini) the mini is that like abdc now ans dc the maxlength is 3 so not possible we can min(task,n-i) it will min length that possible and store in result and compare which one is greater store that and return the result

// Time complexity:o(n*n) n for travese and n for substring
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