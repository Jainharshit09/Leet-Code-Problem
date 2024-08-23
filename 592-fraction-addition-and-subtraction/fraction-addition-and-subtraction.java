class Solution {
    public int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
    public String fractionAddition(String exp) {
        int num=0;
        int deno=1;
        int i=0;
        int n=exp.length();
        while(i<n){
            int curr_num=0;
            int curr_deno=0;
            boolean minus=(exp.charAt(i)=='-');
            if(exp.charAt(i)=='-' || exp.charAt(i)=='+'){
                i++;
            }
            while(i<n && Character.isDigit(exp.charAt(i))){
                int value=exp.charAt(i)-'0';
                curr_num=(curr_num*10)+value;
                i++;
            }
            i++;
            if(minus){
                curr_num*=-1;
            }
             while(i<n && Character.isDigit(exp.charAt(i))){
                int value=exp.charAt(i)-'0';
                curr_deno=(curr_deno*10)+value;
                i++;
             }
             num= num*curr_deno+ curr_num*deno;
             deno=deno*curr_deno;
        }
        int gcd= gcd(Math.abs(num),deno);
        num/=gcd;
        deno/=gcd;
        return num + "/" + deno;
    }
}