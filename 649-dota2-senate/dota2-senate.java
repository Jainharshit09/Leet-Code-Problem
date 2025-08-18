class Solution {
    int n;
    public void removeOtherParty(String senate,boolean taken[],char del,int idx){
        while(true){
            if(senate.charAt(idx)==del && taken[idx]==false){
                taken[idx]=true;
                break;
            }
            idx=(idx+1)%n;
        }
    }
    public String predictPartyVictory(String senate) {
        n=senate.length();
        boolean taken[]=new boolean[n];
        int R_count=0;
        for(int i=0;i<n;i++){
            if(senate.charAt(i)=='R')R_count++;
        }
        int D_count=n-R_count;
        int idx = 0;
        while(R_count!=0 && D_count!=0){
            if(!taken[idx]){
                if(senate.charAt(idx)=='R'){
                    removeOtherParty(senate,taken,'D',idx);
                    D_count--;
                }
                else{
                    removeOtherParty(senate,taken,'R',idx);
                    R_count--;
                }
            }
            idx=(idx+1)%n;
        }
        return R_count==0 ? "Dire":"Radiant";
    }
}