class Solution {
    public int longestPalindrome(String s) {
        int freq=0;
        HashMap<Character,Integer> map=new HashMap<>();
        for(char ch :s.toCharArray()){
            if(!map.containsKey(ch)){
                map.put(ch,1);
            }
            else{
                map.put(ch,map.get(ch)+1);
            }
            if(map.get(ch)%2==1){
                freq++;
            }
            else{
                freq--;
            }
        }
        if(freq>1){
            return s.length()-freq+1;
        }
        return s.length();
    }
}