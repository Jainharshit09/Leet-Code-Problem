class pair{
    String x;
    int y;
    pair(String x1,int y1){
        x=x1;
        y=y1;
    }
}
class Solution {
        public int solve(String[]nums,int k,int trim){
            PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->(b.x.compareTo(a.x))==0?b.y-a.y:b.x.compareTo(a.x));
            for(int i=0;i<nums.length;i++){
                String num=nums[i];
                String trimmedValue=num.substring(num.length()-trim);
                pq.add(new pair(trimmedValue, i));
                if(pq.size()>k){
                    pq.poll();
                }
            }
            return pq.poll().y;
        }
        public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
            int m=queries.length;
            int ans[]=new int[m];
            for(int i=0;i<m;i++){
                int k=queries[i][0];
                int trim=queries[i][1];
                ans[i]=solve(nums,k,trim);
            }
            return ans;
        }
    }