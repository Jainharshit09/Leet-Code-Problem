//given buliding[i]=[l,r,h]
// we nee to find first point at a index like 3,15 and 2,12 we take 2 ,15 becuase it come first
// focuse toward the sorting or heap we can use
// we can solve make start,end ,height divide in start,-height and end,height
// and also take max compare with new height if new height is large update max ans also add in ans 
// if we get positive height it means we need to remove that and check we reomve that height is differ for  same max if that change max and also add in answer the at which end it will change with maxheight
// to store all height we can use mulitset
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>>ans=new ArrayList<>();
        List<int[]>score=new ArrayList<>();
        for(int a[]:buildings){
            int start=a[0];
            int end=a[1];
            int height=a[2];
            score.add(new int[]{start,-height});
            score.add(new int[]{end,height});
        }
        int currHeight=0;
        Collections.sort(score, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];  
            return a[1] - b[1];                        
        });
        TreeMap<Integer,Integer>set=new TreeMap<>(Collections.reverseOrder());
        set.put(0,1);

        for(int []x:score){
            int currindex=x[0];
            int height=x[1];
            if(height<0){
                height*=-1;
                set.put(height,set.getOrDefault(height,0)+1);
                if(currHeight!=set.firstKey()){
                    currHeight=set.firstKey();
                    List<Integer>result=new ArrayList<>();
                    result.add(currindex);
                    result.add(currHeight);
                    ans.add(result);
                }
            }
            else if(height>0){
                set.put(height,set.getOrDefault(height,0)-1);
                if(set.get(height)==0){
                    set.remove(height);
                }
                if(set.firstKey()!=currHeight){
                     currHeight=set.firstKey();
                    List<Integer>result=new ArrayList<>();
                    result.add(currindex);
                    result.add(currHeight);
                    ans.add(result);
                }
            }
        }
        return ans;
    }
}