class Solution {
    public int minimumLength(String s) {
        int n=s.length();
        int count=0
       
        ;
        int freq[]=new int[26];
        for(int i=0;i<n;i++){
            int idx=s.charAt(i)-'a';
            freq[idx]++;
            if(freq[idx]==3){
                count+=2;
                freq[idx]=1;
            }
        }
        return n-count;
    }
}