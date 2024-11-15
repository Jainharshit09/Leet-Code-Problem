class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        HashMap<Integer,Integer> freq=new HashMap<>();
        HashMap<Integer,Integer> range=new HashMap<>();
        int minRange=Integer.MAX_VALUE;
        int maxRange=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
            int left=nums[i]-k;
            int right=nums[i]+k;
            minRange=Math.min(minRange,left);
            maxRange=Math.max(maxRange,right);
            range.put(left,range.getOrDefault(left,0)+1);
            range.put(right+1,range.getOrDefault(right+1,0)-1);
        }
        int ans=1;
        int currentRangeSum = 0;
        for(int i=minRange;i<=maxRange;i++){
             currentRangeSum += range.getOrDefault(i, 0);
            int curr=freq.getOrDefault(i, 0);
            int maxfreq=currentRangeSum-curr;
            maxfreq=Math.min(maxfreq,numOperations);
            maxfreq+=curr;
            ans=Math.max(ans,maxfreq);
        }
        return ans;
    }
}