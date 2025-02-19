class Solution {
    ArrayList<String>ans;
    public boolean isValid(StringBuilder curr){
        int len = curr.length();
        return len < 2 || curr.charAt(len - 1) != curr.charAt(len - 2);
    }
    public void solve(int n,StringBuilder curr,int freq[]){
        if(curr.length()==n){
            ans.add(curr.toString());
            return;
        }
        for(int i=0;i<3;i++){
                if(freq[i]==0){
                    continue;
                }
                //do
                char ch = (char) ('a' + i);
                curr.append(ch);
                freq[i]--;

                //explore
                if(isValid(curr)){
                    solve(n,curr,freq);
                }

                //undo
                curr.deleteCharAt(curr.length() - 1);
                freq[i]++;
        }
    }
    public String getHappyString(int n, int k) {
        int freq[]=new int[3];
        ans=new ArrayList<>();
        Arrays.fill(freq,n);
        solve(n,new StringBuilder(),freq);
        return ans.size() >= k ? ans.get(k - 1) : "";
    }
}