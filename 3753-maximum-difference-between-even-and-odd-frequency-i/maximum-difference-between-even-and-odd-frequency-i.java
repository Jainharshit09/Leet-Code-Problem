class Solution {
    public int maxDifference(String s) {
        int even =Integer.MAX_VALUE;
        int odd=0;
        int n=s.length();
        int arr[]=new int[26];
        for(int i=0;i<n;i++){
            int index=s.charAt(i)-'a';
            arr[index]++;
        }
        for(int i=0;i<26;i++){
            if(arr[i]!=0 && arr[i]%2==0){
                even=Math.min(even,arr[i]);
            }
            else{
                odd=Math.max(odd,arr[i]);
            }
        }
        return odd-even;
    }
}