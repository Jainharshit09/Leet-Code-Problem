class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        int total=n*n;
        k=total-k+1;
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        for(int row[]:matrix){
            for(int i=0;i<row.length;i++){
                pq.add(row[i]);
                if(pq.size()>k)pq.poll();
            }
        }
        return pq.peek();
    }
}