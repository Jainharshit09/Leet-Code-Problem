class Solution {
    public long calculateScore(String[] instructions, int[] values) {
        int n=values.length;
        boolean vis[]=new boolean[n];
        int index=0;
        long score=0;
        while( index>=0 && index<n && !vis[index]){
            vis[index]=true;
            if(instructions[index].equals("jump")){
                index+=values[index];
            }
            else if(instructions[index].equals("add")){
                 score+=values[index];
                 index++;
            }
        }
        return score;
    }
}