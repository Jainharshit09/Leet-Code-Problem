class Pair{
     public char c;
    public int i;
    public Pair(char c,int i){
        this.c=c;
        this.i=i;
    }
}
class Solution {
    public String clearStars(String s) {
         char[] str = s.toCharArray();
         PriorityQueue<Pair>pq=new PriorityQueue<>((a, b) -> {
           if (a.c == b.c) {
               return b.i - a.i;
           }
            return Character.compare(a.c, b.c);
        });
        for(int i=0;i<str.length;i++){
            char ch=str[i];
           if(ch!='*'){
             pq.add(new Pair(ch,i));
           }
           else{
             Pair curr=pq.poll();
             str[curr.i]='*';
           }
        }
        StringBuilder result=new StringBuilder();
        for(int i=0;i<str.length;i++){
            if(str[i]!='*'){
                result.append(str[i]);
            }
        }
        return result.toString();
    }
}