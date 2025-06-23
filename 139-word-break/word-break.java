// for optimzation we can use trie stor word wordDict
class Trie{
    Trie ch[];
    boolean isEnd;
    public Trie(){
        ch=new Trie[26];
        for(int i=0;i<26;i++){
            ch[i]=null;
        }
        isEnd=false;
    }
    public void insert(Trie root,String s){
        Trie curr=root;
        for(int i=0;i<s.length();i++){
            int idx=s.charAt(i)-'a';
            if(curr.ch[idx]==null){
                curr.ch[idx]=new Trie();
            }
            curr=curr.ch[idx];
        }
        curr.isEnd=true;
    }
    public boolean search(Trie root,String str){
        Trie curr=root;
        for(int i=0;i<str.length();i++){
            int index=str.charAt(i)-'a';
            if(curr.ch[index]==null){
                return false;
            }
            curr=curr.ch[index];
        }
        if(curr!=null && curr.isEnd==true)
            return true;

        return false;
    }
}
class Solution {
    int n;
    int dp[];
    public boolean solve(int idx,String s,Trie root){
        if(idx>=n)return true;
        if(dp[idx]!=-1){
            return dp[idx]==0?false:true;
        }
        Trie curr=root;
        for(int i=idx;i<n;i++){
            int index=s.charAt(i)-'a';
            if(curr.ch[index]==null)break;
            curr=curr.ch[index];
            if(curr.isEnd){
                if(solve(i+1,s,root)){
                    dp[idx]=1;
                    return true;
                }
            }
        }
        dp[idx]=0;
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie root=new Trie();
        n=s.length();
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        for(String res:wordDict){
            root.insert(root,res);
        }
        return solve(0,s,root);
    }
}