class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->b[2]-a[2]);
        int n=nums1.length;
        int m=nums2.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int sum=nums1[i]+nums2[j];
                if(pq.size()<k){
                    pq.add(new int[]{nums1[i],nums2[j],sum});
                }
                else if(pq.peek()[2]>sum){
                    pq.poll();
                    pq.add(new int[]{nums1[i],nums2[j],sum});
                }
                else break;
            }
        }
        List<List<Integer>>ans=new ArrayList<>();
        while(!pq.isEmpty()){
            int curr[]=pq.poll();
            ArrayList<Integer>res=new ArrayList<>();
            res.add(curr[0]);
            res.add(curr[1]);
            ans.add(0,res);
        }
        return ans;
    }
}