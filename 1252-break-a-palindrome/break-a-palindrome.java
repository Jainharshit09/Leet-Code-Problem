// check string is not a palindrome return empty string
// if all characater are same in that replace last one is correct
// if next one is not same replace with min char
//f even length than go next if find it is not a than change to a automatically become smallest
// in that aabaa if odd than what you think
//like if length is odd then we do mid will come even that time check we go till 5/2=2 means index will be 0-1 if both are same and move i to last element
// in even case also same that think 
class Solution {
    public String breakPalindrome(String s) {
        StringBuilder str=new StringBuilder(s);
        int n=str.length();
        if(n==1)return "";
        for(int i=0;i<n/2;i++){
            char ch=str.charAt(i);
            if(ch!='a'){
                str.setCharAt(i,'a');
                return str.toString();
            }
        }
        str.setCharAt(n-1,'b');
        return str.toString();
    }
}