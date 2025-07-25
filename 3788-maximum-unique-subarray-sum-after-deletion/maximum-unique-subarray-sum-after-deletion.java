class Solution {
    public int maxSum(int[] nums) {
        int maxi=Integer.MIN_VALUE;
        Set<Integer>set=new HashSet<>();
        for(int a:nums){
            if(!set.contains(a) && a>=0){
                set.add(a);
            }
            maxi=Math.max(maxi,a);
        }
        int ans=0;
        if(set.isEmpty()){
            return maxi;
        }
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            ans+=iterator.next();
        }
        return ans;
    }
}