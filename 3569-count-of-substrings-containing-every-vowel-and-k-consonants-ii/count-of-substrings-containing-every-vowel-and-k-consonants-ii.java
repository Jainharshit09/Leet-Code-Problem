class Solution {
    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public long countOfSubstrings(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        long ans = 0;
        int n = s.length();
        int cons = 0;
        int i = 0;
        int j = 0;
        int cosntIdx=n;
        int arr[]=new int[n];
        for(int l=n-1;l>=0;l--){
            char ch=s.charAt(l);
            arr[l]=cosntIdx;
            if(!isVowel(ch)){
                cosntIdx=l;
            }   
        }
        while (j < n) {
            char ch = s.charAt(j);
            if (isVowel(ch)) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            } else {
                cons++;
            }
            while (cons > k) {
                char leftChar = s.charAt(i);
                if (isVowel(leftChar)) {
                    map.put(leftChar, map.get(leftChar) - 1);
                    if (map.get(leftChar) == 0)
                        map.remove(leftChar);
                } else {
                    cons--;
                }
                i++;
            }
           while(i<n && map.size()==5 && cons==k){
                ans+=(arr[j]-j);
                char curr_i=s.charAt(i);
                if(isVowel(curr_i)){
                    map.put(curr_i,map.get(curr_i)-1);
                    if (map.get(curr_i) == 0)
                        map.remove(curr_i);
                }
                else {
                    cons--;
                }
                i++;
           }
            j++;
        }
        return ans;
    }
}