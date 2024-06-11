class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
     int ans[]=new int[arr1.length];
     HashMap<Integer,Integer> map=new HashMap<>();
     for(int i=0;i<arr1.length;i++){
        if(!map.containsKey(arr1[i])){map.put(arr1[i],1);}
        else{map.put(arr1[i],map.get(arr1[i])+1);}
     }
     int j=0;
        for(int i=0;i<arr2.length;i++){
            if(map.containsKey(arr2[i])){
            int count=map.get(arr2[i]);
            for(int k=0;k<count;k++)
               {
                    ans[j++]=arr2[i];
                }
            }
            map.remove(arr2[i]);
         }
        List<Integer> remaining = new ArrayList<>();
            for (int num : map.keySet()) {
            int count = map.get(num);
            for (int i = 0; i < count; i++) {
                remaining.add(num);
            }
        }
        Collections.sort(remaining);
        for (int num : remaining) {
            ans[j++] = num;
        }
        return ans;
   }
}