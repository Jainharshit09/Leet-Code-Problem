class Solution {
    public List<String> partitionString(String s) {
        Set<String>set=new HashSet<>();
        List<String> ans=new ArrayList<>();
        String curr="";
        for(int i=0;i<s.length();i++){
            curr+=s.charAt(i);
            if(!set.contains(curr)){
                set.add(curr);
                ans.add(curr);
                curr="";
            }
        }
        return ans;
    }
}