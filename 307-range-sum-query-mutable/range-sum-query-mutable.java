class NumArray {
    int bit[];
    int nums[];
    int n;
    public NumArray(int[] nums) {
        n=nums.length;
        bit=new int[n+1];
       this. nums=nums;
        for(int i=0;i<n;i++){
            updateQuery(i,nums[i]);
        }
    }

    public void updateQuery(int index,int val){
        for(int i=index+1;i<=n;i+=(i&-i)){
            bit[i]+=val;
        }
    }

    public void update(int index, int val) {
      int diff=val-nums[index];
      nums[index]=val;
      updateQuery(index,diff);
    }

    public int sumRange(int left, int right) {
        return sum(right)-sum(left-1);
    }
    public int sum(int i){
        int ans=0;
        for(i+=1;i>0;i-=(i & -i)){
            ans+=bit[i];
        }
        return ans;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */