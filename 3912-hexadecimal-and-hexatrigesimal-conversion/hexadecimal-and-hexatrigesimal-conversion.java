class Solution {
    public String concatHex36(int n) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        int x1 = n * n;
        int x2 = n * n * n;
        while(x1>0){
            int curr=x1%16;
            x1/=16;
            if(curr>9){
                curr-=10;
                s1.append((char)(curr + 'A'));
            }
            else{
                 s1.append((char)(curr + '0'));
            }
        }
        while(x2>0){
            int curr=x2%36;
            x2/=36;
            if(curr>9){
                curr-=10;
                s2.append((char)(curr + 'A'));
            }
            else{
                 s2.append((char)(curr + '0'));
            }
        }
        return s1.reverse().toString() + s2.reverse().toString();
    }
}