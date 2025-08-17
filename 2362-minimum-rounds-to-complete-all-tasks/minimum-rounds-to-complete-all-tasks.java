class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<tasks.length;i++){
            map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
        }
        int ans=0;
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            int key=entry.getValue();
            if(key==1)return -1;
            if(key%3==0)ans+=key/3;
            else if(key%3==1){
                ans+=(key-4)/3+2;
            }
            else{
                ans+=(key-2)/3+1;
            }
        }
        return ans;
    }
}