//like store in hashmap
// than we doing in reverse order like not using heap we can create list<Integer>[] 
// all we get the freq and at that index store the value

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
        List<Integer>[]min=new List[n+1];
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            int value=entry.getKey();
            int freq=entry.getValue();
            if(min[freq]==null){
                min[freq]=new ArrayList<>();
            }
            min[freq].add(value);
        }
        int ans[]=new int[k];
         int index = 0;
        for(int i=min.length-1;i >= 0 && index < k;i--){
             if (min[i] != null) {
                for(int val:min[i]){
                    ans[index++]=val;
                    if(index==k)break;
                }
             }
        }
        return ans;
    }
}