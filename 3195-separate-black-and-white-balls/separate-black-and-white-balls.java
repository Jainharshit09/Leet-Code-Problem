class Solution {
    public long minimumSteps(String s) {
        int n=s.length();
        long answer=0;
        int black=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1'){
                black++;
            }
            else{
                answer+=black;
            }
        }
        return answer;
    }
}