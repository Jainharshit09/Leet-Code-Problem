class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int n= nums.length;
        for(int i=0;i<n;i++){
            pq.add(new int[]{nums[i],i});
            if(pq.size()>k)pq.poll();
        }
        List<int[]> selected = new ArrayList<>(pq);
        selected.sort(Comparator.comparingInt(a -> a[1]));
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = selected.get(i)[0];
        }
        return result;
    }
}