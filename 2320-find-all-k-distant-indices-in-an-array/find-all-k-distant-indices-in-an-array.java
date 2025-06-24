class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        Set<Integer>set=new HashSet<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==key){
                int min=i-k;
                int max=i+k;
                if(min<0){
                    min=0;
                }
                if(max>=n){
                    max=n-1;
                }
                for(int j=min;j<=max;j++){
                    set.add(j);
                }
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(int s:set){
            ans.add(s);
        }
        Collections.sort(ans);
        return ans;
    }
}