class Solution {
    public int maximum69Number (int num) {
        int ans=num;
        StringBuilder str=new StringBuilder(String.valueOf(num));
        for(int i=0;i<str.length();i++){
            boolean isChanged=false;
            int ch=str.charAt(i)-'0';
            if(ch==9)continue;
            if(ch==6){str.setCharAt(i,'9');
            isChanged=true;}
            ans=Math.max(ans,Integer.parseInt(str.toString()));
            if(isChanged==true){
                str.setCharAt(i,'6');
            }
        } 
        return ans;
    }
}