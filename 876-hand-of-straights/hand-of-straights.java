class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize!=0){
            return false;
        }
        Arrays.sort(hand);
          TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i=0;i<hand.length;i++){
            if(!map.containsKey(hand[i])){
                map.put(hand[i],1);
            }
            else{
                map.put(hand[i],map.get(hand[i])+1);
            }
        }
        while(!map.isEmpty()){
              int curr = map.firstKey();
              for(int i=0;i<groupSize;i++){
                if(!map.containsKey(curr+i)){
                    return false;
                }
                 map.put(curr + i, map.get(curr + i) - 1);
                 if(map.get(curr+i)==0){
                    map.remove(curr+i);
                 }
              }
        }
        return true;
    }
}