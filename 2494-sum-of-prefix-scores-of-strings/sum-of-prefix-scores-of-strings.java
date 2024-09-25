class TrieNode{
    TrieNode children[]=new TrieNode[26];
    int count=0;
}
class Solution {
    public TrieNode getNode(){
        return new TrieNode();
    }
    public void insert(TrieNode root,String word){    
        TrieNode temp=root;
          for (char ch : word.toCharArray()){
            int idx=ch-'a';
            if(temp.children[idx]==null){
                temp.children[idx]=getNode();
            }
            temp=temp.children[idx];
           temp.count++; 
        }
    }
    public int getScore (TrieNode root,String word){
        TrieNode temp=root;
        int score=0;
        for(char ch : word.toCharArray()){
            int idx=ch-'a';
            score+= temp.children[idx].count;
            temp=temp.children[idx];
        }
        return score;
    }
    public int[] sumPrefixScores(String[] words) {
        int ans[]=new int [words.length];
        TrieNode root=getNode();
        for(String word:words){
            insert(root,word);
        }
        for(int i=0;i<words.length;i++){
            ans[i]=getScore(root,words[i]);
        }
        return ans;
    }
}