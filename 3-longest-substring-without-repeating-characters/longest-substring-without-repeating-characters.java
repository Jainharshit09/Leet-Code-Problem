class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> map=new HashSet<>();
        int i=0;
        int j=0;
        int ans=0;
        while(j<s.length()){
            char ch=s.charAt(j);
            if(!map.contains(ch)){
                map.add(ch);
                ans=Math.max(ans,map.size());
                j++;
            }
            else{
                     map.remove(s.charAt(i));
                    i++;
             
            }
        }
        return ans;
    }
}