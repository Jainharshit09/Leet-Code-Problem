class Solution {
    public int solve(int nums[],int i,int turn,int limit,int product,int k, HashMap<List<Integer>,Integer>dp){
        if(i==nums.length && k==0 && product<=limit && turn!=0){
            return product;
        }
        if(i==nums.length){
            return -1;
        }
        //agar sum 0 ho gya or product cross ho jya ga limit sa tab limit +1 kar da ga like example nums = [2, 5, 4] k=7 limit=10 "If product crosses the limit, mark it as invalid to skip this path
        if(product>limit){
            product=limit+1;
        }
        List<Integer>temp=new ArrayList<>();
        temp.add(i);
        temp.add(turn);
        temp.add(product);
        temp.add(k);
        if(dp.containsKey(temp)){
            return dp.get(temp);
        }
        int ans=-1;
        //Not take
        ans=Math.max(ans,solve(nums,i+1,turn,limit,product,k,dp));
        //take condition
        ans=Math.max(ans,solve(nums,i+1,turn==2?1:2,limit,product*nums[i],k-(turn==2?-nums[i]:nums[i]),dp));
        dp.put(temp,ans);
        return ans;
    }
    public int maxProduct(int[] nums, int k, int limit) {
        HashMap<List<Integer>,Integer>dp=new HashMap<>();
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        sum=Math.min(sum,900);
        if(k<-sum || k>sum){
            return -1;
        }
        return solve(nums,0,0,limit,1,k,dp);
    }
}