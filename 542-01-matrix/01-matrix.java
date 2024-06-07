    class Solution {
        int n,m;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        public int[][] updateMatrix(int[][] mat) {
            n=mat.length;
            m=mat[0].length;
            Queue<int[]> q= new LinkedList<>();
            int[][] result=new int[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(mat[i][j]==0){
                        q.add(new int[]{i,j});
                    }
                    else{
                        result[i][j]=-1;
                    }
                }
            }
            while(!q.isEmpty()){
            int[] ans=q.poll(); 
            int i=ans[0];
            int j=ans[1];
            for(int[]dir :directions ){
                int new_i=i+dir[0];
                int new_j=j+dir[1];
                if(new_i>=0 && new_i<n && new_j>=0 && new_j<m && result[new_i][new_j]==-1){
                    result[new_i][new_j]=result[i][j]+1;
                    q.add(new int[]{new_i,new_j});
                }
            }
            }
            return result;
        }
    }