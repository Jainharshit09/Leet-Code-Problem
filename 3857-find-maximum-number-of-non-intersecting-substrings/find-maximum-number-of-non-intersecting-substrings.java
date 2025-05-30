class Solution {
    // start end with same character
    //  also length is 4
    //store the index ig again get then curr_index-prevIndex+1>=4 then increment the result and also make array -1 again whole array
    public int maxSubstrings(String word) {
        int count[]=new int[26];
        Arrays.fill(count,-1);
        int n=word.length();
        int result=0;
        for(int i=0;i<n;i++){
            int curr_value_index=word.charAt(i)-'a';
            if(count[curr_value_index]!=-1 && i-count[curr_value_index]+1>=4){
                result++;
                Arrays.fill(count,-1);
            }
            else if(count[curr_value_index]!=-1){
                continue;
            }
            else{
                count[curr_value_index]=i;
            }
        }
        return result;
    }
}