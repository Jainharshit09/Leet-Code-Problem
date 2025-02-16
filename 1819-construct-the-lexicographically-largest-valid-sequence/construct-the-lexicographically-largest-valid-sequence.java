class Solution {
    public boolean solve(int n,int ans[],boolean used[],int i){
        if(i==ans.length){
            return true;
        }
        if(ans[i]!=-1){
            return solve(n,ans,used,i+1);
        }
        for(int num=n;num>=1;num--){
            if(used[num]==true){
                continue;
            }   

            //try
            used[num]=true;
            ans[i]=num;

            //Explore
            if(num==1){
                if(solve(n,ans,used,i+1)==true){
                    return true;
                }
            }
            else{
                int j=i+ans[i];
                if(j<ans.length && ans[j]==-1){
                    ans[j]=num;
                    if(solve(n,ans,used,i+1)==true){
                        return true;
                    }
                    ans[j]=-1;
                }

            }
            used[num]=false;
            ans[i]=-1;
        }
        return false;
    }
    public int[] constructDistancedSequence(int n) {
        int ans[]=new int[2*n-1];
        Arrays.fill(ans,-1);
        boolean used[]=new boolean[n+1];
        solve(n,ans,used,0);
        return ans;
    }
}