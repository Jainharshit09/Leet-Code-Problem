class Solution {
    public static final int M=1_000_000_007;
    public int lengthAfterTransformations(String s, int t) {
        int mp[]=new int[26];
        for(int i=0;i<s.length();i++){
            int idx=s.charAt(i)-'a';
            mp[idx]++;
        }
        for(int i=1; i<=t;i++){
            int temp[]=new int[26];
            for(int j=0;j<26;j++){
                char ch=(char)(j+'a');
                int freq=mp[j];
                if(ch!='z'){
                     temp[(ch + 1) - 'a'] = (temp[(ch + 1) - 'a'] + freq) % M;
                }
                else{
                    temp['a'-'a']=(temp['a'- 'a'] + freq) % M;
                    temp['b'-'a']=(temp['b'- 'a'] + freq) % M;
                }
            }
            mp=temp;
        }
        int count=0;
        for(int i=0;i<26;i++){
            count=(count+mp[i])%M;
        }
        return count;
    }
}