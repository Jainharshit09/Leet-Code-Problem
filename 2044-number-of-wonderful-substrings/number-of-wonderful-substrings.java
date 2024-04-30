class Solution {
    HashMap<Long,Long> map=new HashMap<>();
    public long wonderfulSubstrings(String word) {
        map.put(0L,1L);
        int curr_xor=0;
       long result=0;
        for(char ch : word.toCharArray()){
        int shift= ch-'a';
        curr_xor^=(1 << shift);
       result += map.getOrDefault((long) curr_xor, 0L);
       for(char ch1='a';ch1<='j';ch1++){
        shift=ch1-'a';
        long check_xor = (curr_xor ^ (1 << shift));
         result += map.getOrDefault((long) check_xor, 0L);
       }
        map.put((long) curr_xor, map.getOrDefault((long) curr_xor, 0L) + 1);
    }
    return result;
  }
}