class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n=fruits.length;
        int m =baskets.length;
        int unplaced=0;
        boolean vis[]=new boolean[m];
        for(int i=0;i<n;i++){
            int curr=fruits[i];
            boolean check=false;
            for(int j=0;j<m;j++){
                int take=baskets[j];
                if(curr<=take && vis[j]==false){
                    vis[j]=true;
                    check=true;
                    break;
                }
            }
            if(check==false){
                unplaced++;
            }
        }
        return unplaced;
    }
}