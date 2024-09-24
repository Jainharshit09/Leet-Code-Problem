class TrieNode {
    TrieNode[] children = new TrieNode[10];
}

class Solution {
    public TrieNode getNode() {
        return new TrieNode();
    }

    public void insert(int n, TrieNode root) {
        TrieNode temp=root;
        String num=Integer.toString(n);
        for (char ch : num.toCharArray()){
            int idx=ch-'0';
            if(temp.children[idx]==null){
                temp.children[idx]=getNode();
            }
            temp=temp.children[idx];
        }
    }

    public int search(int n, TrieNode root) {
        TrieNode temp=root;
        String num=Integer.toString(n);
        int length=0;
        for(char ch:num.toCharArray()){
            int idx=ch-'0';
            if(temp.children[idx]!=null){
                length++;
                temp=temp.children[idx];
            }
            else{
                break;
            }
        }
        return length;
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        TrieNode root = getNode();
        for (int num : arr1) {
            insert(num, root);
        }
        int result = 0;
        for (int val : arr2) {
            result = Math.max(result, search(val, root));
        }
        return result;
    }
}