class Solution {
    public boolean solve(int n,int p){
        if(n==0){
            return true;
        }
        if(Math.pow(3,p)>n){
            return false;
        }
        boolean take_it=solve(n-(int)Math.pow(3,p),p+1);
        boolean not_take_it=solve(n,p+1);
        return take_it||not_take_it;
    }
    public boolean checkPowersOfThree(int n) {
        return solve(n,0);
    }
}