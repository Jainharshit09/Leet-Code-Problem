class Solution {
    String ans="";
    public void solve(Set<String>set,int freq[],StringBuilder curr,int n){
        if(curr.length()==n && !set.contains(curr)){
            ans=curr.toString();
            return;
        }
        for(int i=0;i<2;i++){
            if(freq[i]==0){
                continue;
            }
            freq[i]--;
            char ch = (char) ('0' + i);
            curr.append(ch);
            if(!set.contains(curr.toString())){
                solve(set,freq,curr,n);
            }
           curr.deleteCharAt(curr.length() - 1);
            freq[i]++;
        }
    }
    public String findDifferentBinaryString(String[] nums) {
        Set<String>set=new HashSet<>();
        int size=nums[0].length();
        int n=nums.length;
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        int freq[]=new int[2];
        Arrays.fill(freq,n);
        StringBuilder curr=new StringBuilder();
        solve(set,freq,curr,size);
        return ans;
    }
}