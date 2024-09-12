class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set=new HashSet<>();
        for(int i=0;i<allowed.length();i++){
            set.add(allowed.charAt(i));
        }
        int count=0;
        for(int i=0;i<words.length;i++){
            String ch=words[i];
            int temp=0;
            for(int k=0;k<ch.length();k++){
                char c=ch.charAt(k);
                if(!set.contains(c)){
                    temp=0;
                    break;
                }
                temp=1;
            }
            count+=temp;
        }
        return count;
    }
}