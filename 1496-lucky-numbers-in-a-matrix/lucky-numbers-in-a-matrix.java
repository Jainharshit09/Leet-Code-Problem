class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        Set<Integer>set=new HashSet<>();
        List<Integer> ans=new ArrayList<>();
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<m;i++){
            int count=Integer.MIN_VALUE;
            for(int j=0;j<n;j++){
                count=Math.max(count,matrix[j][i]);
            }
            set.add(count);
        }
        for(int i=0;i<n;i++){
            int count=Integer.MAX_VALUE;
            for(int j=0;j<m;j++){
                count=Math.min(count,matrix[i][j]);
            }
           if(set.contains(count)){
            ans.add(count);
           }
        }
        return ans;
    }
}