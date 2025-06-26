// we need to find value<=k
// need max length value possible
// if it zero we can add in count because not affect the on any value to increase 
// if it is one check it value valid or not if valid decrease the k and move the power till k is large
class Solution {
    public int longestSubsequence(String s, int k) {
        int n=s.length();
        long power=1;
        int count=0;
        for(int i=n-1;i>=0;i--){
            int ch=s.charAt(i)-'0';
            if(ch==0){
                count++;
            }
            else if(ch==1 && power<=k){
                k-=power;
                count++;
            }
            if(power<=k){
                power=power << 1;
            }
        }
        return count;
    }
}