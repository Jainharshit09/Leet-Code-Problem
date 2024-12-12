class Solution {
    public long pickGifts(int[] gifts, int k) {
        long ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int gift : gifts) {
            pq.add(gift);
        }
        while (k-- > 0) {
            int largestGift = pq.poll();
            int nm= (int)Math.sqrt(largestGift);
            pq.add(nm);
        }
        while(!pq.isEmpty()){
            ans+=(long)pq.poll();
        }
        return ans;
    }
}