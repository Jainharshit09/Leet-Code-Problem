class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m=rolls.length;
        int overall=mean*(n+m);
        int sum=0;
        for(int i=0;i<m;i++){
            sum+=rolls[i];
        }
        int remain=overall-sum;
        if(n>remain ||6*n<remain){
            return new int[0];
        }
        int result[]=new int[n];
        int r=remain%n;
        int value=remain/n;
        for(int i=0;i<n;i++){
            result[i]=value+(i<r?1:0);
        }
        return result;
    }
}