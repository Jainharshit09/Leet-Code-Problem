//i think in which trie will be used because like string is lt in trie tl is there means we take it  if 
//or we can use hashmap also like in string store and if check there reverse that present than increase the count+=4 and decrase it value;
//now for same character if both 1 and second 2 means count+=2 and break only one time we can add
class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String,Integer>map=new HashMap<>();
        int count=0;
        for(String word:words){
            String reversed=new StringBuilder(word).reverse().toString();
            if(map.containsKey(reversed)){
                count+=4;
                map.put(reversed,map.getOrDefault(reversed,0)-1);
                if(map.get(reversed)<=0) map.remove(reversed);
            }
            else{
                map.put(word,map.getOrDefault(word,0)+1);
            }
        }
        for(Map.Entry<String,Integer> e:map.entrySet()){
            String word=e.getKey();
            int result = e.getValue();
            if(word.charAt(0)==word.charAt(1) && result>0){
                count+=2;
                break;
            }
        }
        return count;
    }
}