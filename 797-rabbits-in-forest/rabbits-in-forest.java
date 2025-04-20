class Solution {
    public int numRabbits(int[] answers) {
        int ans=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        int zero=0;
        for(int i=0;i<answers.length;i++){
                 map.put(answers[i],map.getOrDefault(answers[i],0)+1);
           
        }
      for(Map.Entry<Integer,Integer>entry:map.entrySet()){
        int x=entry.getKey();
        int count=entry.getValue();
         int groupSize = x + 1;
         int groups = (int) Math.ceil((double) count / groupSize);
         ans+=(groups*groupSize);
      }
        return ans;
    }
}