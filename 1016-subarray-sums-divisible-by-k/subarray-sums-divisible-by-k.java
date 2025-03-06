class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(0,1);
        int sum=0;
        int result=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            int rem=sum%k;
            if(rem<0){
                rem+=k;
            }
            if(!map.containsKey(rem)){
                map.put(rem,1);
            }
            else{
                result+=map.get(rem);
                map.put(rem,map.get(rem)+1);
            }
        }
        return result;
    }
}