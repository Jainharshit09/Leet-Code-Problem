class Solution {
    public boolean hammingDistanceOne(String word,String word2){
        int diff=0;
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)!=word2.charAt(i)){
                diff++;
                 if (diff > 1) return false;
            }
        }
        return true;
    }
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n=words.length;
        int dp[]=new int[n];
        int parent[]=new int[n];
        int lisIndex=0;
        int lis=1;
        Arrays.fill(parent,-1);
        Arrays.fill(dp,1);
        for(int i=0;i<n;i++){
            for(int j=0;j<=i-1;j++){
                if(groups[i]!=groups[j] && words[i].length()==words[j].length() &&  hammingDistanceOne(words[i], words[j])){
                    if(dp[j]+1>dp[i]){
                        dp[i]=dp[j]+1;
                        parent[i] = j;
                        if(dp[i]>lis){
                            lis=dp[i];
                            lisIndex=i;
                        }
                    }
                }
            }
        }
        List<String>ans=new ArrayList<>();
        while(lisIndex!=-1){
            ans.add(words[lisIndex]);
            lisIndex=parent[lisIndex];
        }
        Collections.reverse(ans);
        return ans;
    }
}