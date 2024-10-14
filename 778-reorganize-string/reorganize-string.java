class Solution {
    public String reorganizeString(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        PriorityQueue<int[]>pq= new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
        }
        StringBuilder result=new StringBuilder();
        int n=s.length();
        int ans=(n+1)/2;
         int[] prev = null; 
        while(!pq.isEmpty()){
            int curr[]=pq.poll();
            char ch=(char)curr[0];
            int value=curr[1];
            if(value>ans){
                return "";
            }
            if(result.length() > 0 && result.charAt(result.length() - 1) == ch && !pq.isEmpty()){
                 if (pq.isEmpty()) {
                    return "";
                }
                int next[]=pq.poll();
                char nextCh = (char) next[0];
                int nextValue = next[1];
                result.append(nextCh);
                nextValue--;
                pq.add(curr);
                if (nextValue > 0) {
                    pq.offer(new int[] { nextCh, nextValue });
                }
            }
            else{
                result.append(ch);
                value--;
                if (value > 0) {
                    pq.offer(new int[] { ch, value });
                }
            }

        }
        return result.toString();
    }
}