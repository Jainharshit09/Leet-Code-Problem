class Solution {
    public char kthCharacter(long k, int[] operations) {
        if(k==1){
            return 'a';
        }
        int n=operations.length;
        long len=1;
        long newK=k;
        int operType=0;
        for(int i=0;i<n;i++){
            len*=2;
            if(len>=k){
                operType=operations[i];
                newK=k - len/2;
                break;
            }  
        }
        char ch=kthCharacter(newK,operations);
        if(operType==0){
            return ch;
        }
        if(ch=='z'){
            return 'a';
        }
        return (char)(ch+1);
    }
}
