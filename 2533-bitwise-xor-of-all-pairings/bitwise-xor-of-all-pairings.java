class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int xor=0;
        int m=nums2.length;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums1[i],map.getOrDefault(nums1[i],0)+m);
        }
        for(int i=0;i<m;i++){
            map.put(nums2[i],map.getOrDefault(nums2[i],0)+n);
        }
        for(int num : map.keySet()){
            if(map.get(num)%2==1){
                xor^=num;
            }
        }
        return xor;
    }
}