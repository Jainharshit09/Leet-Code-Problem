function mergeAlternately(word1: string, word2: string): string {
    let i=0;
    let j=0;
    let n=word1.length;
    let m=word2.length;
    let ans="";
    while(i<n && j<m){
        ans+=word1[i++];
        ans+=word2[j++];
    }
    while(i<n){
        ans+=word1[i++];
    }
    while(j<m){
        ans+=word2[j++];
    }
    return ans;
};