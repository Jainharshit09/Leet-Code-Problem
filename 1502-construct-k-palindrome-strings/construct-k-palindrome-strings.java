class Solution {
    public boolean canConstruct(String s, int k) {
        int n=s.length();
        if(n<k){
            return false;
        }
        if(n==k){
            return true;
        }
        int arr[]=new int [26];
        for(int i=0;i<n;i++){
            int idx=s.charAt(i)-'a';
            arr[idx]++;
        }
        int odd_count=0;
        for(int i=0;i<26;i++){
            if(arr[i]%2==1){
                odd_count++;
            }
        }
        if(odd_count>k){
            return false;
        }
        return true;
    }
}