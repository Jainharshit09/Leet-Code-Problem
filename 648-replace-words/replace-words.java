class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> map=new HashSet<>();
        for(int i=0;i<dictionary.size();i++){
            map.add(dictionary.get(i));
        }
        StringBuilder result=new StringBuilder();
        String [] input=sentence.split(" ");
        for(int i=0;i<input.length;i++){
            String ans= input[i];
            StringBuilder prefix= new StringBuilder();
            for(int j=0;j<ans.length();j++){
                char ch=ans.charAt(j);
                prefix.append(ch);
                if (map.contains(prefix.toString())) {
                    ans=prefix.toString();
                    break;
                }
            }
                result.append(ans).append(" ");
        }
        return result.toString().trim();
    }
}