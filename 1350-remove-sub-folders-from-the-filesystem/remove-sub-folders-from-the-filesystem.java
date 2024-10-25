class Solution {
    public List<String> removeSubfolders(String[] folder) {
        List<String>ans=new ArrayList<>();
        Set<String>set=new HashSet<>(Arrays.asList(folder));
        for(String st:folder){
            boolean isSubfolder=false;
            String temp=st;
            while(!temp.isEmpty()){
                int last =st.lastIndexOf('/');
                if(last==-1){
                    break;
                }
                st = st.substring(0, last);
                if(set.contains(st)){
                    isSubfolder=true;
                    break;
                } 
            }
            if(!isSubfolder){
                ans.add(temp);
            }
        }
        return ans;
    }
}