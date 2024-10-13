class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int k=nums.size();
        int maxEl = Integer.MIN_VALUE;
        PriorityQueue<int[]>pq=new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for(int i=0;i<k;i++){
            pq.add(new int[]{nums.get(i).get(0), i, 0});
            maxEl=Math.max(maxEl, nums.get(i).get(0));
        }
        int [] result= {-1000000,1000000};
        while(!pq.isEmpty()){
            int curr[]=pq.poll();
            int minEl=curr[0];
            int listIdx=curr[1];
            int idx=curr[2];
            if (maxEl - minEl < result[1] - result[0]) {
                result[0] = minEl;
                result[1] = maxEl;
            }
            if(idx+1<nums.get(listIdx).size()){
                int nextElement=nums.get(listIdx).get(idx+1);
                pq.add(new int[]{nextElement,listIdx,idx+1});
                maxEl=Math.max(maxEl,nextElement);
            }
            else{
                break;
            }
        }
        return result;
    }
}