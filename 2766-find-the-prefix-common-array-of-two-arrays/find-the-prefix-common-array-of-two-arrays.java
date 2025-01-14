class Solution {
    public int[] findThePrefixCommonArray(int[] a, int[] b) {
        int n=a.length;
        int c[]=new int[n];
        boolean count_a[]=new boolean[n+1];
        boolean count_b[]=new boolean[n+1];
        for(int i=0;i<n;i++){
            count_a[a[i]]=true;
            count_b[b[i]]=true;
            int count=0;
            for(int j=1;j<=n;j++){
                if(count_a[j] && count_b[j]){
                    count++;
                }
            }
            c[i]=count;
        }
        return c;
    }
}