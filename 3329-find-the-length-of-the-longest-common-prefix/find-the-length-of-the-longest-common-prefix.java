// class TrieNode{
 //     TrieNode[] children=new TrieNode[10];
 //     public TrieNode(){
 //         for(int i=0;i<9;i++){
 //             children[i]=null;
 //         }
 //     }
 // }
class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
     Set<Integer> set=new HashSet<>();
     int ans=0;
     for(int i=0;i<arr1.length;i++){
        String str = String.valueOf(arr1[i]);
        int n = 0;
        for (int j = 0; j < str.length(); j++){
            char ch = str.charAt(j);
            n = n * 10 + (ch - '0');
            set.add(n);
        }
     }
     for(int i=0;i<arr2.length;i++){
        String str = String.valueOf(arr2[i]);
        int n=0;
        for(int j=0;j<str.length();j++){
            char ch=str.charAt(j);
            n = n * 10 + (ch - '0'); 
            if(set.contains(n)){
                ans=Math.max(ans,j+1);
            }
        }
     }
     return ans;
    }
}