//like using min PrioirtyQueue on the basis of there diff
// we need to count cap and rocks are equal weight
// if not equal than using additionRocks we can add and we get our ans and we get max bages
class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
        int count=0;
        for(int i=0;i<rocks.length;i++){
            pq.add(new int[]{capacity[i],rocks[i],capacity[i]-rocks[i]});
        }
        while(!pq.isEmpty() && additionalRocks>0){
            int curr[]=pq.poll();
            if(curr[2]==0){
                count++;
                continue;
            }
            int cap=curr[0];
            int ro=curr[1];
            int needed=curr[2];
            if(additionalRocks>=needed){
                additionalRocks-=needed;
                count++;
            }
        }
        return count;
    }
}