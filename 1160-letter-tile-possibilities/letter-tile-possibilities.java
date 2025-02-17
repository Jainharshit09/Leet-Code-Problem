class Solution {
     int n;
     public boolean solve(String tiles,StringBuilder curr,Set<String>set ,boolean used[]){
        set.add(curr.toString());
        for(int i=0;i<n;i++){
            if(used[i]==true){
                continue;
            }
            // Do
            used[i]=true;
            curr.append(tiles.charAt(i));
            //Explore
            if(solve(tiles,curr,set,used)){
                return true;
            }
            // Undo
            used[i]=false;
            curr.deleteCharAt(curr.length()-1);
        }
        return false;
     }
    public int numTilePossibilities(String tiles) {
        n=tiles.length();
        Set<String>set=new HashSet<>();
        boolean used[]=new boolean[n];
        StringBuilder curr=new StringBuilder();
        solve(tiles,curr,set,used);
        return set.size()-1;
    }
}