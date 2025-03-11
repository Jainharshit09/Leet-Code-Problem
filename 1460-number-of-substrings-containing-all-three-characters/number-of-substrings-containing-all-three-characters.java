class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int i=0,j=0;
        HashMap<Character,Integer>map=new HashMap<>();
        int ans=0;
        while(j<n){
            char ch=s.charAt(j);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.size()==3){
                char left=s.charAt(i);
                ans+=(n-j);
                map.put(left,map.getOrDefault(left,0)-1);
                if(map.get(left)==0){
                    map.remove(left);
                }
                i++;
            }
            j++;
        } 
        return ans;
    }
}