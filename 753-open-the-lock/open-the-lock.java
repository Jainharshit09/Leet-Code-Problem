class Solution {
    public void findNeighbours(Queue<String> q,StringBuilder curr,Set<String> map){
        for(int i=0;i<4;i++){
            char ch=curr.charAt(i);
            char dc= (ch=='0' )? '9' : (char)(ch-1);
             char ic=(ch=='9' )? '0': (char)(ch+1);
             curr.setCharAt(i, dc);
             String dncStr = curr.toString();
            if(!map.contains(dncStr)){
                map.add(dncStr);
                q.add(dncStr);
            }
            curr.setCharAt(i, ic);
             String incStr = curr.toString();
            if(!map.contains(incStr)){
                map.add(incStr);
                q.add(incStr);
            }
             curr.setCharAt(i,ch);
        }
    }
    public int openLock(String[] deadends, String target) {
       Set<String>map=new HashSet<>();
        String start="0000";
        for(String mapend : deadends){
            map.add(mapend);
        }
         if (map.contains(start)) {
            return -1;
        }
         Queue<String> q=new LinkedList<>();
        q.add(start);
        int level=0;
        while(!q.isEmpty()){
            int n=q.size();
            while(n-- >0){
                String curr=q.poll();
                if(curr.equals(target)){
                    return level;
                }
                StringBuilder currBuilder = new StringBuilder(curr);
                findNeighbours(q,currBuilder,map);
            }
            level++;
        }
        return -1;
    }
}