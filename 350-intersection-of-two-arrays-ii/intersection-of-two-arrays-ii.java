class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map2=new HashMap<>();
         for(int i=0;i<nums2.length;i++){
            if(!map2.containsKey(nums2[i])){
                map2.put(nums2[i],1);
            }
            else{
                  map2.put(nums2[i],map2.get(nums2[i])+1);
            }
        }
        ArrayList<Integer>list=new ArrayList<>();
        for(int i=0;i<nums1.length;i++){
            if(map2.containsKey(nums1[i]) && map2.get(nums1[i])>0){
                list.add(nums1[i]);
                 map2.put(nums1[i],map2.get(nums1[i])-1);
            }
        }
         int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result; 
    }
}