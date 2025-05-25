class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String,Integer>map=new HashMap<>();
        int n=words.length;
        int count=0;
        for(String word:words){
              String reversed = new StringBuilder(word).reverse().toString();
              if(map.getOrDefault(reversed, 0) > 0){
                count+=4;
                map.put(reversed,map.getOrDefault(reversed,0)-1);
              }
              else{
                map.put(word,map.getOrDefault(word,0)+1);
              }
        }

        for(Map.Entry<String,Integer>entry:map.entrySet()){
             String word = entry.getKey();
            int result = entry.getValue();
            if(word.charAt(0)==word.charAt(1) && result>0){
                count+=2;
                break;
            }
        }
        return count;
    }
}