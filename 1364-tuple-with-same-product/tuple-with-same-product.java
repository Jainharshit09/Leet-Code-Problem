class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int n=nums.length;
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int product=nums[i]*nums[j];
                int count=map.getOrDefault(product, 0);
                 ans+=8*count;
                map.put(product, count + 1);
            }
        }
        return ans;
    }
}