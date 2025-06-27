// we need to  lexicographically largest one isSubsequence
//like first subseq complete than next one come
//also like we can take freq of every element having min equal to k
//it is combiantion of backtraking and isSubsequence
//like in isSubsequence rather than creating a combine long string we can use mod
//in which same first subseq we find we start with j and till j*k at the time comparing we do j%m(length of subseq)
//time complexity is o(n)*(n/k)! beacuse n/k! we are finding all the string and checking 

// we can also more optimize the backtracking like we know maxLen we it may be ans so rathe passing the maxlen we can create a loop from maxLen to 1 and passing that len 


class Solution {
    String result="";
    public boolean isSubsequence(String s,String str,int k){
        int i=0;
        int j=0;
        int n=s.length();
        int m=str.length();
        while(i<n && j<k*m){
            if(s.charAt(i)==str.charAt(j%m)){
                j++;
            }
            i++;
        }
        return j==k*m;
    }
    public void backtracking(String s,StringBuilder curr,boolean canUse[],int reqFreq[],int maxLen,int k){
        if(curr.length()>maxLen)return;
        String currStr=curr.toString();
        if ((currStr.length() > result.length() || 
             (curr.length() == result.length() && currStr.compareTo(result) > 0)) &&
            isSubsequence(s, currStr, k)) {
            result = currStr;
        }
        for(int i=25;i>=0;i--){
            if(canUse[i]==false || reqFreq[i]==0)continue;
            //DO
            curr.append((char) (i + 'a'));
            reqFreq[i]--;

            //Explore
            backtracking(s,curr,canUse,reqFreq,maxLen,k);

            //Backtack
            curr.deleteCharAt(curr.length()-1);
            reqFreq[i]++;
        }

    }
    public String longestSubsequenceRepeatedK(String s, int k) {
        int n=s.length();
        int freq[]=new int[26];
        for(int i=0;i<n;i++){
            int ch=s.charAt(i)-'a';
            freq[ch]++;
        } 
        boolean canUse[]=new boolean[26];
        int [] reqFreq=new int[26];
        for(int i=0;i<26;i++){
            if(freq[i]>=k){
                canUse[i]=true;
                reqFreq[i]=freq[i]/k;
            }
        }
        int maxLen=n/k;
        StringBuilder curr = new StringBuilder();
        backtracking(s,curr,canUse,reqFreq,maxLen,k);
        return result;
    }
}