class Solution {
    public void solve(String s,int idx,HashSet<String> set,int currCount,int maxcount[]){
        if(idx==s.length()){
             maxcount[0]=Math.max(maxcount[0],currCount);
             return;
        }
        for(int j=idx;j<s.length();j++){
             String sub = s.substring(idx, j + 1);
             if(!set.contains(sub)){
                set.add(sub);
                 solve(s, j + 1, set, currCount + 1, maxcount);
                 set.remove(sub);
             }
        }
    }
    public int maxUniqueSplit(String s) {
        HashSet<String> set=new HashSet<>();
        int maxcount[]=new int[1];
        solve(s,0,set,0,maxcount);
        return maxcount[0];
    }
}