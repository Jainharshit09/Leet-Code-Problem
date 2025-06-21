class Solution {
    public int minimumDeletions(String word, int k) {
        int freq[]=new int [26];
        int n=word.length();
        for(int i=0;i<n;i++){
            int ch=word.charAt(i)-'a';
            freq[ch]++;
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<26;i++){
            int delete=0;
            for(int j=0;j<26;j++){
                if(freq[j]<freq[i]){
                    delete+=freq[j];
                }
                else if(Math.abs(freq[j]-freq[i])>k){
                    delete+=Math.abs(freq[j]-freq[i]-k);
                }
            }
            ans=Math.min(delete,ans);
        }
        return ans;
    }
}