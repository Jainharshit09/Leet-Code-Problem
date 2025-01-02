class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int arr[]=new int[words.length];
        for(int i=0 ;i<words.length;i++){
            String str=words[i];
            int m=str.length();
            char first=str.charAt(0);
            char last=str.charAt(m-1);
            if((first== 'a'||first== 'e'||first== 'i'||first== 'o'|| first=='u') && (last== 'a'||last== 'e'||last== 'i'||last== 'o'|| last=='u')){
                arr[i]=1;
            }
            else{
                arr[i]=0;
            }
        }
        int prefixSum[]=new int[arr.length];
        prefixSum[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            prefixSum[i]=arr[i]+prefixSum[i-1];
        }
        int ans[]=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int start=queries[i][0];
            int end=queries[i][1];
            if(start==0){
                ans[i]=prefixSum[end];
            }
            else{
                ans[i]=prefixSum[end]-prefixSum[start-1];
            }
        }
        return ans;
    }
}