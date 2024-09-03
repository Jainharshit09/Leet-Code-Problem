class Solution {
    public int getLucky(String s, int k) {
        StringBuilder str=new StringBuilder();
        for(int i=0;i<s.length();i++){
            int ch=s.charAt(i)-'a'+1;
            str.append(ch);
        }
        for(int j=0;j<k;j++){
            int sum=0;
            for(int i=0;i<str.length();i++){
                sum+=str.charAt(i)-'0';
            }
           str = new StringBuilder(Integer.toString(sum));
        }
        return Integer.parseInt(str.toString());
    }
}