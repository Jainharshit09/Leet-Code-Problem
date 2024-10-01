class Solution {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int a:arr){
             int temp=((a % k)+k)%k;
              map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        for(int r:map.keySet()){
            int count=map.get(r);
            if(r==0){
                if(count%2!=0){
                    return false;
                }

            }
            else{
                int ans=k-r;
                if (map.getOrDefault(ans, 0) != count){
                    return false;
                }
            }
        }
        return true;
    }
}