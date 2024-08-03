class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int n=target.length;
        int m=arr.length;
        if(n!=m){
            return false;
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<target.length;i++){
            map.put(target[i],map.getOrDefault(target[i],0)+1);
        }
        for(int i=0;i<m;i++){
            if(map.containsKey(arr[i])){
                 map.put(arr[i],map.get(arr[i])-1);
                 if(map.get(arr[i])==0){
                    map.remove(arr[i]);
                 }
            }
            else{
                return false;
            }
        }
       return map.isEmpty();
    }
}