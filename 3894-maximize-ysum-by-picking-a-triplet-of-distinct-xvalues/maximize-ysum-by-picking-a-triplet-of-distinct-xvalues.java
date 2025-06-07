class Solution {
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int n=x.length;
        for(int i=0;i<n;i++){
            if(map.containsKey(x[i])){
                int curr=map.get(x[i]);
                if(curr<y[i]){
                    map.put(x[i],y[i]);
                }
            }
            else{
                map.put(x[i],y[i]);
            }
        }
        if(map.size()<3){
            return -1;
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(int arr:map.keySet()){
            ans.add(map.get(arr));
        }
        Collections.sort(ans);
        int size = ans.size();
        int result=ans.get(size-1)+ans.get(size-2)+ans.get(size-3);
        return result;
    }
}