class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n=s.length();
        StringBuilder str=new StringBuilder(s);
        int remain=n%k;
        if(remain!=0){
            for(int i=0;i<k - remain;i++){
                str.append(fill);
            }
        }
        List<String>ans=new ArrayList<>();
        for (int i = 0; i < str.length(); i += k) {
            ans.add(str.substring(i, i + k));
        }
         return ans.toArray(new String[0]);
    }
}