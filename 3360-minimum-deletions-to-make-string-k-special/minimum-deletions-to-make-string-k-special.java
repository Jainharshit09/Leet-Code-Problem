//for optimization we can sort the freq
// already know that prev are already smaller so using cum_sum add in delete
// so we also start from ending in j loop till we get no delete need we break at that point


class Solution {
    public int minimumDeletions(String word, int k) {
        int freq[]=new int [26];
        int n=word.length();
        for(int i=0;i<n;i++){
            int ch=word.charAt(i)-'a';
            freq[ch]++;
        }
        Arrays.sort(freq);
        int ans=Integer.MAX_VALUE;
        int sum=0;
        for(int i=0;i<26;i++){
            int delete=sum;
            for(int j=25;j>i;j--){
                
                if(freq[j]-freq[i]<=k){
                   break;
                }
                    delete+=Math.abs(freq[j]-freq[i]-k);
            }
            ans=Math.min(delete,ans);
            sum+=freq[i];
        }
        return ans;
    }
}



// class Solution {
//     public int minimumDeletions(String word, int k) {
//         int freq[]=new int [26];
//         int n=word.length();
//         for(int i=0;i<n;i++){
//             int ch=word.charAt(i)-'a';
//             freq[ch]++;
//         }
//         int ans=Integer.MAX_VALUE;
//         for(int i=0;i<26;i++){
//             int delete=0;
//             for(int j=0;j<26;j++){
//                 if(freq[j]<freq[i]){
//                     delete+=freq[j];
//                 }
//                 else if(Math.abs(freq[j]-freq[i])>k){
//                     delete+=Math.abs(freq[j]-freq[i]-k);
//                 }
//             }
//             ans=Math.min(delete,ans);
//         }
//         return ans;
//     }
// }