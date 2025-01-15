class TrieNode{
    TrieNode children[];
    boolean endOfWord;
    public TrieNode(){
        this.children=new TrieNode[26];
        this.endOfWord=false;
    }
}
class Trie{
    TrieNode root;
    public Trie(){
        this.root=new TrieNode();
    }
    public void insert(String word){
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new TrieNode();
            }
            curr=curr.children[idx];
        }
        curr.endOfWord=true;
    }
        public TrieNode getRoot() {
        return root;
    }
}
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie node=new Trie();
        int n=wordDict.size();
        for(int i=0;i<n;i++){
            node.insert(wordDict.get(i));
        }
        int m=s.length();
        boolean dp[]=new boolean[m+1];
        dp[0]=true;
        for(int i=0;i<m;i++){
             if (!dp[i]) continue;
            TrieNode trie = node.getRoot();
            for(int j=i;j<m;j++){
                int idx=s.charAt(j)-'a';
                if(trie.children[idx]==null){
                    break;
                }
                trie=trie.children[idx];
                if(trie.endOfWord==true){
                    dp[j+1]=true;
                }
            }
        }
        return dp[m];
    }
}