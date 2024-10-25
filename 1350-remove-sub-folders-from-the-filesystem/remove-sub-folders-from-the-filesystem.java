class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String>ans=new ArrayList<>();
        ans.add(folder[0]);
        for(int i=1;i<folder.length;i++){
            String curr=folder[i];
            String last=ans.get(ans.size() - 1);
            last+='/';
            if(!curr.startsWith(last)){
                ans.add(curr);
            }
        }
        return ans;
    }
}