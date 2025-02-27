class Solution {
    public int lenLongestFibSubseq(int[] arr) {

        int n=arr.length;
        int ans=0;
        Set<Integer>set=new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(arr[i]);
        }
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n;j++){
                 int result = 2;
                int k=arr[i];
                int l=arr[j];
                while(set.contains(k+l)){
                    result++;
                    int temp=k+l;
                    k=l;
                    l=temp;
                }
                ans=Math.max(ans,result);
            }
        }
        return ans > 2 ? ans : 0;
    }
}