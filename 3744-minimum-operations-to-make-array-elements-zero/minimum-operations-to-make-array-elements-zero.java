class Solution {
    public long minOperations(int[][] queries) {
        long ans=0;
        for(int i=0;i<queries.length;i++){
            int start=queries[i][0];
            int end=queries[i][1];
            long prev=1;
            long ops=0;
            for(int power=1;power<17;power++){
                long curr=prev*4;
                long l=Math.max(prev,start);
                long r=Math.min(curr-1,end);
                if(r>=l){
                    ops+=(r-l+1)*power;
                }
                prev=curr;
            }
            ans+=(ops+1)/2;
        }
        return ans;
    }
}