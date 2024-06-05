class Solution {
    public void fillcountArray(String words,int count[]){
        for(char ch:words.toCharArray()){
            count[ch-'a']++;
        }
    }
    public List<String> commonChars(String[] words) {
         List<String> ans = new ArrayList<>();
        int n=words.length;
        int count[]=new int[26];
        fillcountArray(words[0],count);
        for(int i=1;i<n;i++){
            int temp[]=new int[26];
            fillcountArray(words[i],temp);
            for(int j=0;j<26;j++){
                count[j]=Math.min(count[j],temp[j]);
            }
        }
       for (int i = 0; i < 26; i++) {
            int c = count[i];
            while (c-- > 0) {
                ans.add(String.valueOf((char) (i + 'a')));
            }
        }
        return ans;
    }
}