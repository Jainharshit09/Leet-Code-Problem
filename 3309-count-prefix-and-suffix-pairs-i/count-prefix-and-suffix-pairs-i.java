class TrieNode{
    TrieNode children[];
    boolean isEndOfWord;
    public TrieNode(){
        this.children=new TrieNode[26];
        this.isEndOfWord=false;
    }
}
class Trie{
    TrieNode root;
    public Trie(){
         root = new TrieNode();
    }
    public void insert(String word){
         TrieNode pCrawl = root;
         for (int i = 0; i < word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if (pCrawl.children[idx] == null) {
                pCrawl.children[idx] = new TrieNode();
            }
            pCrawl=pCrawl.children[idx];
            
         }
          pCrawl.isEndOfWord = true;
    }
    public boolean search(String word){
         TrieNode pCrawl = root;;
         for (int i = 0; i < word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if (pCrawl.children[idx] == null) {
                return false;
            }
            pCrawl = pCrawl.children[idx];
        }
        return true;
         }
}
class Solution {

    public int countPrefixSuffixPairs(String[] words) {
        int n=words.length;
        int count=0;
        for(int j=0;j<n;j++){
            Trie prefixTrie = new Trie();
            Trie suffixTrie = new Trie();
            prefixTrie.insert(words[j]);
            String reversed = new StringBuilder(words[j]).reverse().toString();
            suffixTrie.insert(reversed);
            for(int i=0;i<j;i++){
                if(words[i].length()>words[j].length()){
                    continue;
                }
                 String rev = new StringBuilder(words[i]).reverse().toString();
                if(prefixTrie.search(words[i]) && suffixTrie.search(rev)){
                    count++;
                }
            }
        }
        return count;
    }
}