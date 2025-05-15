class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String>ans=new ArrayList<>();
        int n=words.length;
        int last_number=-1;
        for(int i=0;i<n;i++){
            if(last_number==-1){
                ans.add(words[i]);
                last_number=groups[i];
            }
            if(last_number!=groups[i]){
                ans.add(words[i]);
                last_number=groups[i];
            }
        }
        return ans;
    }
}