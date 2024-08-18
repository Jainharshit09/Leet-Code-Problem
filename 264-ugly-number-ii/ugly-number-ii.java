
class Solution {
    public int nthUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }
        
        int[] arr = new int[n];
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        pq.add(1L);
        set.add(1L);
        
        int index = 0;
        while (index < n) {
            long curr = pq.poll();
            arr[index++] = (int) curr;
            
            if (set.add(curr * 2)) {
                pq.add(curr * 2);
            }
            if (set.add(curr * 3)) {
                pq.add(curr * 3);
            }
            if (set.add(curr * 5)) {
                pq.add(curr * 5);
            }
        }
        
        return arr[n - 1];
    }
}
