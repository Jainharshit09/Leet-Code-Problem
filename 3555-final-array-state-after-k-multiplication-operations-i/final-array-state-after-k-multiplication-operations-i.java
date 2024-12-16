class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->{
            if(a[0]!=b[0]){
                return Integer.compare(a[0], b[0]);
            }
            return  Integer.compare(a[1], b[1]);
        });
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            pq.add(new int[] { nums[i], i });
        }
        for (int i = 0; i < k; i++) {
            int arr[] = pq.poll();
            int curr = arr[0];
            int index = arr[1];
            pq.add(new int[] { curr * multiplier, index });
        }
        while (!pq.isEmpty()) {
            int arr[] = pq.poll();
            int curr = arr[0];
            int index = arr[1];
            nums[index] = curr;
        }
        return nums;
    }
}