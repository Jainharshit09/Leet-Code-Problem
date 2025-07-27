//given a nums array and upper and lower
// the upper an lower is range  the sum of subarray lies in between
// first find the prefix sum
// sum(i,j)=sum[i]+sum[j] we can rewrite like than using sum(i,j)=prefix[j+1]-prefix[i]; so prefix[i]=prefix[i] ≥ prefix[j + 1] - upper
//prefix[i] ≤ prefix[j + 1] - lower
//now using fenwick tree but there is prefix sum will be work on positive to make it we can do like mapping with sum index+1 index will start with zero it will do in sorted order
// after that call a query on that left and right and in count
// than call update to Add current prefix sum
class Solution {
    long bit[];

     void update(int i, int delta) {
        while (i < bit.length) {
            bit[i] += delta;
            i += i & -i;
        }
    }
    public int query(int i){
        int sum=0;
        while(i>0){
            sum+=bit[i];
            i-= i & -i;
        }
        return sum;
    }

    public int queryRange(int l,int r){
        return query(r)-query(l-1);
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        //cal prefix sum
        long prefix[] = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        //Collect all values needed for coordinate compression
        TreeSet<Long>set=new TreeSet<>();
        for(long x:prefix){
            set.add(x);
            set.add(x-lower);
            set.add(x-upper);
        }
        HashMap<Long,Integer>indices=new HashMap<>();
        int index=0;
        for(long s:set){
            indices.put(s,index+1);
            index++;
        }

        bit=new long[indices.size()+2];
        int count=0;
        for(long x:prefix){
           int l = indices.get(x - upper);
           int r = indices.get(x - lower);
            count+=queryRange(l,r);
            update(indices.get(x),1);
        }
        return count;
    }
}