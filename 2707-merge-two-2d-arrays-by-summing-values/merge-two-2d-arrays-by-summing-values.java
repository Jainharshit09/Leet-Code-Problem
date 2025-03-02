class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        Set<Integer>set=new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(nums1[i][0]);
        }
        for(int j=0;j<m;j++){
            set.add(nums2[j][0]);
        }
        int ans[][]=new int[set.size()][2];
        int n1=0;
        int n2=0;
        int k=0;
        while(n1<n && n2<m){
            if(nums1[n1][0]==nums2[n2][0]){
                int value=nums1[n1][1]+nums2[n2][1];
                ans[k][0]=nums1[n1][0];
                ans[k][1]=value;
                n1++;
                n2++;
            }
            else if(nums1[n1][0]>nums2[n2][0]){
                ans[k][0]=nums2[n2][0];
                ans[k][1]=nums2[n2][1];
                n2++;

            }
            else{
                 ans[k][0]=nums1[n1][0];
                ans[k][1]=nums1[n1][1];
                n1++;
            }
            k++;
        }
        while(n1<n){
              ans[k][0]=nums1[n1][0];
                ans[k][1]=nums1[n1][1];
                n1++;
                k++;
        }
        while(n2<m){
             ans[k][0]=nums2[n2][0];
                ans[k][1]=nums2[n2][1];
                n2++;
                k++;
        }
        return ans;
    }
}