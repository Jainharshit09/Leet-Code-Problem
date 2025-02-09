class Solution {
    public long countBadPairs(int[] nums) {
        long good=0;
        int n=nums.length;
        HashMap<Integer,Long>map=new HashMap<>();
        for(int i=0;i<n;i++){
            int num=nums[i];
            int curr=num-i;
            good+=map.getOrDefault(curr,0L);
            map.put(curr,map.getOrDefault(curr,0L)+1);
        }
        long total=(long)n*(n-1)/2;
        return total-good;
    }
}