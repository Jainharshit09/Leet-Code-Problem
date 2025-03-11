class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int ans=0;
        int arr[]={-1,-1,-1};
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            arr[ch-'a']=i;
            ans+=1+Math.min(arr[0],Math.min(arr[1],arr[2]));
        }
        return ans;
    }
}