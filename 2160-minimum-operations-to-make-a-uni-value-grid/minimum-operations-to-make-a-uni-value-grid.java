class Solution {
    public int minOperations(int[][] grid, int x) {
        int n=grid.length;
        int m=grid[0].length;
        
        int ans=0;
        List<Integer>list=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                list.add(grid[i][j]);
            }
        }
        Collections.sort(list);
        int mid=list.size()/2;
        int median=list.get(mid);
        for(int i=0;i<mid;i++){
            if((median-list.get(i))%x!=0){
                return -1;
            }
            ans+=(median-list.get(i))/x;
        }
        for(int i=mid+1;i<list.size();i++){
            if((list.get(i)-median)%x!=0){
                return -1;
            }
            ans+=(list.get(i)-median)/x;
        }
        return ans;
    }
}