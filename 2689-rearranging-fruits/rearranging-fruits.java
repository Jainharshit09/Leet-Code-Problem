//given 2 basket
//need to make both equal
//cost of swap is min(basket1[i],basket2[j]);
//need to return min cost

//observation
//sort the array
// store their freq in 2 different map 
// then check there sum is even than ans is possbile if odd than not possible by checking second example
//now think greedly because need min ans
// check those freq mismatch store in another list
//how i can do greedly 
//we can do the two pointer apporach but in that case 1,100,100 and 1,200,200 in that ans is 2 we get the wrong answer according to it 100 
// we can greedly find the min and do ans+=Min(2*min,curr_Val) needed4\
//the last one is most important observation 
class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        long ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int minElement = Integer.MAX_VALUE;
        for(int x:basket1){
            map.put(x,map.getOrDefault(x,0)+1);
            minElement=Math.min(minElement,x);
        }
        for(int x:basket2){
            map.put(x,map.getOrDefault(x,0)-1);
            minElement=Math.min(minElement,x);
        }

        ArrayList<Integer>result=new ArrayList<>();
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            int cost=entry.getKey();
            int count=entry.getValue();
            if(count==0)continue;
            if(count%2!=0)return -1;
            for(int i=1;i<=Math.abs(count)/2;i++){
                result.add(cost);
            }
        }
        Collections.sort(result);
        for(int i=0;i<result.size()/2;i++){
            ans+=Math.min(result.get(i),2*minElement);
        }
        return ans;
    }
}