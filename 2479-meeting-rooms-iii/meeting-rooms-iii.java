class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int freq[]=new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] != b[1] ? a[1] - b[1] : a[2] - b[2]);
        var unusedRoom=new PriorityQueue<Integer>();
        for(int i=0;i<n;i++){
            unusedRoom.add(i);
        }
        Arrays.sort(meetings,(a,b)->Integer.compare(a[0],b[0]));
        for(int arr[]:meetings){
            int mStart=arr[0];
            int mEnd=arr[1];
            while (!pq.isEmpty() && pq.peek()[1] <= mStart) {
                unusedRoom.offer(pq.poll()[2]);
            }

            if(!unusedRoom.isEmpty()){
                int room=unusedRoom.poll();
                freq[room]++;
                pq.add(new int[]{arr[0],arr[1],room});
            }
            else{
                int curr[]=pq.poll();
                int start=arr[1]-arr[0];
                int end=curr[1];
                int roomNo=curr[2];
                freq[roomNo]++;
                pq.add(new int[]{end,end+start,roomNo});
            }
        }
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (freq[i] > freq[ans]) {
                ans = i;
            }
        }
        return ans;
    }
}