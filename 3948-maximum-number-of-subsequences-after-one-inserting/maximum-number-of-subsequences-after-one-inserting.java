// need to make LCT max subsequence
// if subsequence is there means dp
// now can we do
// LMCT we need to check LCT is possible to make from that yes LCMT and LCT possible 1 times now we add L or T than possible is 2
// LLCMT or LCMTT 


// observation 
// 1. for every c find it left L count and T right count
// this will focus on Prefix and suffix
// than store all count in ans
// than which position is best to either L or C or T 
// for L starting
// for T ending
// for C need to find get max L*T at that position we cab insert


// now how to calculate prefix and suffix
// than find the ans=Math.max(ans+L,ans+C,ans+T)
// for all we L=ansL+=(L+1)*T;
// for t we can T=ansT+=(t+1)*L;
// now c curr=Math.max(curr,prefix[i]*suffix[i+1])
// ansC+=c;
// in the end we can do Math.max(ansL,ansT,ansC);
class Solution {
    public long numOfSubsequences(String s) {
        int n=s.length();
        if(n<=1){
            return 0;
        }
        long prefixL[]=new long[n+1];
        long suffixT[]=new long[n+1]; 
        for(int i=0;i<n;i++){
            prefixL[i+1]=prefixL[i]+(s.charAt(i)=='L' ? 1 : 0);
        }
        for(int i=n-1;i>=0;i--){
            suffixT[i]=suffixT[i+1]+(s.charAt(i)=='T' ? 1 : 0);
        }
        long ans=0;
        long ansL=0;
        long ansT=0;
        long bestC=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='C'){
                // curr c
                ans+=(prefixL[i]*suffixT[i+1]);
                //insert L at starting;
                ansL+=(prefixL[i]+1)*suffixT[i+1];
                //insert T and ending
                ansT+=(suffixT[i+1]+1)*prefixL[i];
            }
            else{
                // finding best position of c
                bestC=Math.max(bestC,prefixL[i]*suffixT[i]);
            }
        }
        bestC+=ans;
        return Math.max(ansL,Math.max(bestC,ansT));
    }
}