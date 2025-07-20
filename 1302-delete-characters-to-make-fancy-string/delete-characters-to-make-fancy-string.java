class Solution {
    public String makeFancyString(String s) {
        if(s.length()<3)return s;
        int n=s.length();
        int freq=1;
        StringBuilder str=new StringBuilder();
         str.append(s.charAt(0));
        for(int i=1;i<n;i++){
            if(s.charAt(i)==str.charAt(str.length()-1)){
                freq++;
                if(freq<3)str.append(s.charAt(i));
            }
            else{
                freq=1;
                str.append(s.charAt(i));
            }
        }
        return str.toString();
    }
}