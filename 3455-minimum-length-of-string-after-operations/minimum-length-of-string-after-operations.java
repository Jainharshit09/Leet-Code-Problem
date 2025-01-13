class Solution {
    public int minimumLength(String s) {
        int n=s.length();
        int arr[]=new int[26];
        for(int i=0;i<n;i++){
            int idx=s.charAt(i)-'a';
            arr[idx]++;
        }
        int ans=0;
        for(int i=0;i<26;i++){
            if(arr[i]==0){
                continue;
            }
            if(arr[i]%2==0){
                ans+=2;
            }
            else{
                ans+=1;
            }
        }
        return ans;
    }
}