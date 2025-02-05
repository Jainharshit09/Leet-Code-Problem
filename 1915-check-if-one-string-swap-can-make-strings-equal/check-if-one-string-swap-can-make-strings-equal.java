class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        if(n!=m)return false;
        char[] s1FrequencyMap = new char[26];
        char[] s2FrequencyMap = new char[26];
        int i=0;
        int j=0;
        int swap=0;
        while(i<n && j<n){
            char ch1=s1.charAt(i);
            char ch2=s2.charAt(j);
            if(ch1!=ch2){
                swap++;
                if(swap>2){
                    return false;
                }
            }
            s1FrequencyMap[ch1 - 'a']++;
            s2FrequencyMap[ch2 - 'a']++;
            i++;
            j++;
        }
        return Arrays.equals(s1FrequencyMap, s2FrequencyMap);
    }
}