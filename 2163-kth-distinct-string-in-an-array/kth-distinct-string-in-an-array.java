class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        int count=0;
        for(String t:arr){
            if(map.get(t)==1){
                count++;
                if(count==k){
                    return t;
                }
            }
        }
        return "";
    }
}