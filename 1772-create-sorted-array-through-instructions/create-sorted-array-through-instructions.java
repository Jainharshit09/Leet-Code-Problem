// we need to insert array in sorted need to find small and larger value count
//which one min add in cost min(small,large)
//we can solve using classic fenwik Tree
//we need to find min small value count from that value
// for max we can find overallcount-min we get max
//time complxity of that is n log n 
class Solution {
    int fenwick[]=new int[100001];
    int MOD=(int)1e9+7;
    //log n
    int find(int x){
        int count=0;
        while(x>0){
            count=(count+fenwick[x])% MOD;
            x-=(x & -x);
        }
        return count;
    }
    // log n
    public void update(int x){
        while(x<100001){
            fenwick[x]++;
            x+=(x & -x);
        }
    }
    public int createSortedArray(int[] instructions) {
        int cost=0;
        int n=instructions.length;
        for(int i=0;i<n;i++){
            int smaller=find(instructions[i]-1);
            int larger=i-find(instructions[i]);
            cost=(cost+Math.min(larger,smaller))%MOD;
            update(instructions[i]);
        }
        return cost;
    }

}