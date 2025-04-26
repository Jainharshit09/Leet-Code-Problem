class Solution {
    public List<List<Integer>> generate(int n) {
         List<List<Integer>> ans=new ArrayList<>();
         for(int i=0;i<n;i++){
            Integer row[]=new Integer[i+1];
            Arrays.fill(row,1);
            List<Integer>result=new ArrayList<>(Arrays.asList(row));
            for(int j=1;j<i;j++){
                int val=ans.get(i-1).get(j)+ans.get(i-1).get(j-1);
                result.set(j,val);
            }
            ans.add(result);
         }
         return ans;
    }
}