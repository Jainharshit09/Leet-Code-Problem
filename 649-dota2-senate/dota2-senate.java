//like we can go in circluar motion from in clock wise
// we can solve using queue store both in different queue
// after that which one is next we remove that and add again in it which one is not delete we add in q in end any q will be empty return it oppisite will win

class Solution {
    public String predictPartyVictory(String senate) {
        int n=senate.length();
        Queue<Integer>R_count=new LinkedList<>();
        Queue<Integer>D_count=new LinkedList<>();
        for(int i=0;i<n;i++){
            char ch=senate.charAt(i);
            if(ch=='R')R_count.add(i);
            else{
                D_count.add(i);
            }
        }
        while(!R_count.isEmpty() && !D_count.isEmpty()){
            int r_pos=R_count.poll();
            int d_pos=D_count.poll();
            if(r_pos<d_pos){
                R_count.add(r_pos+n);
            }
            else{
                D_count.add(d_pos+n);
            }
        }
        return R_count.isEmpty()?"Dire":"Radiant";
    }
}