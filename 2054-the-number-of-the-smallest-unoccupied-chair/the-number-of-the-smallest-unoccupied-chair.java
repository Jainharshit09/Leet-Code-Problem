class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n=times.length;
        int arr[]=new int [n];
        Arrays.fill(arr,-1);
        int friend_arrival=times[targetFriend][0];
        Arrays.sort(times,Comparator.comparingInt(a -> a[0]));
        for(int []time:times){
            int arrival=time[0];
            int end=time[1];
            for(int i=0;i<n;i++){
                if(arr[i]<=arrival){
                    arr[i]=end;
                    if(arrival==friend_arrival){
                        return i;
                    }
                    break;
                }
            }
        }
        return -1;
    }
}