class Solution {
    public void solve(int arr[],int target,int  index,ArrayList<Integer>temp,List<List<Integer>> ans,int sum){
        if(index>arr.length || sum>target){
            return;
        }
        if(sum==target){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=index;i<arr.length;i++){
            if(i>index && arr[i]==arr[i-1])continue;
            temp.add(arr[i]);
            solve(arr,target,i+1,temp,ans,sum+arr[i]);
            temp.remove(temp.size()-1);
        }
        return ;
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans= new ArrayList<>();
        solve(candidates,target,0,new ArrayList<>(),ans,0);
        return ans;
    }
}

