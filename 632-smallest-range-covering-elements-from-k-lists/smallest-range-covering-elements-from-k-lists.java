class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int k=nums.size();
        int[]ans=new int[k];
        int [] result= {-1000000,1000000};
        while(true){
           int minEl = Integer.MAX_VALUE;
           int maxEl = Integer.MIN_VALUE;
           int minElListIdx=0;
           for(int i=0;i<k;i++){
            int listIdx=i;
            int elIdx = ans[i];
            int element=nums.get(listIdx).get(elIdx);
            if (element < minEl){
                minEl=element;
                minElListIdx=listIdx;
            }
            maxEl=Math.max(maxEl,element);
           }
           if(maxEl-minEl<result[1]-result[0]){
            result[0]=minEl;
            result[1]=maxEl;
           }
           int nextIndex = ans[minElListIdx] + 1;
           if (nextIndex >= nums.get(minElListIdx).size()){
            break;
           }
           ans[minElListIdx]=nextIndex;
        }
        return result;
    }
}