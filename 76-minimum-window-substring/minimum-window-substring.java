class Solution {
    public String minWindow(String s, String t) {
        if(s.length()==0|| t.length()==0 || s==null || t==null){
            return "";
        }
       HashMap<Character,Integer> map=new HashMap<>();
       for(int k=0;k<t.length();k++){
        char ch=t.charAt(k);
        map.put(ch,map.getOrDefault(ch,0)+1);
       } 
       int i=0;
       int j=0;
       int mini=Integer.MAX_VALUE;
       int count=map.size();
       int start=0;
       while(j<s.length()){
        char ch=s.charAt(j);
        if(map.containsKey(ch)){
            map.put(ch,map.getOrDefault(ch,0)-1);
            if(map.get(ch)==0){
                count--;
            }
        }
            while(count==0){
                if(j-i+1<mini){
                    mini=j-i+1;
                    start=i;
                }
                char curr=s.charAt(i);
                if(map.containsKey(curr)){
                    map.put(curr,map.getOrDefault(curr,0)+1);
                   if (map.get(curr) > 0) {
                        count++;
                    }
                }
                i++;
            }
            j++;
       }
       return  mini==Integer.MAX_VALUE ? "" :s.substring(start,start+mini);
    }
}