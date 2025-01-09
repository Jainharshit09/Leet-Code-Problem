class TrieNode{
    TrieNode children[];
    boolean endOfWord;
    int count;
    public TrieNode(){
        this.children=new TrieNode[26];
        this.endOfWord=false;
        this.count=0;
    }
}
class Trie{
    TrieNode root;
    public Trie(){
        this.root=new TrieNode();
    }
    public void insert(String word){
        TrieNode crawl=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(crawl.children[idx]==null){
                crawl.children[idx]=new TrieNode();
            }
            crawl=crawl.children[idx];
            crawl.count++;
        }
        crawl.endOfWord=true;
    }
    public int search(String word){
        TrieNode crawl=root;
            for (int i = 0; i < word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if (crawl.children[idx] == null) {
                 return 0;
            }
            crawl = crawl.children[idx];
        }
     return crawl.count;
    }
}
class Solution {
    public int prefixCount(String[] words, String pref) {
        Trie node=new Trie();
        int n=words.length;
        for(int i=0;i<n;i++){
            node.insert(words[i]);
        }
        int relatedWords = node.search(pref);
        return relatedWords;
    }
}