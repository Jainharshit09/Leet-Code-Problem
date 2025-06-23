// in same Concatenated word we need to find
// similar to word break problem
// like in that checking that word is part of that or not similar in that question also for memo used hashmap
class Solution {
     Map<String, Boolean> map = new HashMap<>();
     public boolean isConcatenated(String s,Set<String>set){
        if(map.containsKey(s)){
            return map.get(s);
        }
        int l=s.length();
        for(int i=0;i<l;i++){
            String prefix=s.substring(0,i+1);
            String suffix=s.substring(i+1,l);
            if((set.contains(prefix) && set.contains(suffix))||(set.contains(prefix) && isConcatenated(suffix,set))){
                map.put(s,true);
                return true;
            }
        }
        map.put(s,false);
        return false;
     }
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        int n=words.length;
        List<String>result=new ArrayList<>();
         Set<String> set = new HashSet<>();
         for(String s:words){
            set.add(s);
         }
        for(int i=0;i<n;i++){
            String word=words[i];
            if(isConcatenated(word,set)){
                result.add(word);
            }
        }
        return result;
    }
}