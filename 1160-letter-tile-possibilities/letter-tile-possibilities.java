class Solution {
    int count=0;
    public void solve(int freq[]){
        count++;
        for(int i=0;i<freq.length;i++){
            if(freq[i]==0){
                continue;
            }
            freq[i]--;
            solve(freq);
            freq[i]++;
        }
    }
    public int numTilePossibilities(String tiles) {
        int freq[]=new int[26];
        int n=tiles.length();
        for(int i=0;i<n;i++){
            freq[tiles.charAt(i)-'A']++;
        }
        solve(freq);
        return count-1;
    }
}