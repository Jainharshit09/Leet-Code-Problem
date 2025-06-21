// either odd or even on both side of i
// so having 2 choices start from even or odd
// if diff of even size- odd size >1 than not possible return -1
// for putting on correct index even or odd only  curr_index-2*i;
class Solution {
    public int solve(List<Integer>arr){
        int n=arr.size();
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=Math.abs(arr.get(i)-2*i);
        }
        return ans;
    }
    public int minSwaps(int[] nums) {
         int n= nums.length;
        List<Integer>even=new ArrayList<>();
        List<Integer>odd=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(nums[i]%2==0)even.add(i);
            else odd.add(i);
        }
        if(Math.abs(odd.size()-even.size())>1){
            return -1;
        }
        int even_count=even.size();
        int odd_count=odd.size();
        int ans=Integer.MAX_VALUE;
        if(even_count>=odd_count){
            ans=Math.min(ans,solve(even));
        }
         if(even_count<=odd_count){
            ans=Math.min(ans,solve(odd));
        }
        return ans;
    }
}