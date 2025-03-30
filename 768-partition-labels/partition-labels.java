class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer>map=new HashMap<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            map.put(ch,i);
        }
        List<Integer>ans=new ArrayList<>();
        int start=0;
        int end=0;
        int k=start;
        while(start<n){
            end=Math.max(end,map.get(s.charAt(start)));
            if(start==end){
                ans.add(end-k+1);
                k=start+1;
            }
            start++;
        }
        return ans;
    }
}