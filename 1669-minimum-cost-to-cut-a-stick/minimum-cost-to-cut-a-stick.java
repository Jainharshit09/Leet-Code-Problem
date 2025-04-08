class Solution {
    int dp[][]=new int[103][103];
    public int solve( ArrayList<Integer>list,int l,int r){
        if(r-l<2){
            return 0;
        }
        if(dp[l][r]!=-1){
            return dp[l][r];
        }
        int result=Integer.MAX_VALUE;
        for(int index=l+1;index<=r-1;index++){
           result=Math.min(result,(list.get(r)-list.get(l))+solve(list,l,index)+solve(list,index,r));

        }
        return dp[l][r]=result;
         
    }
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        ArrayList<Integer>list=new ArrayList<>();
        list.add(0);
        for(int i=0;i<cuts.length;i++){
            list.add(cuts[i]);
        }
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        list.add(n);
        return solve(list,0,list.size()-1);
    }
}