class Solution {
    public int largestCombination(int[] candidates) {
        int count=0;
        for(int i=0;i<24;i++){
            int result=0;
            for(int bit:candidates){
                if((bit & (1<<i))!=0){
                    result++;
                }
            }
            count=Math.max(result,count);
        }
        return count;
    }
}