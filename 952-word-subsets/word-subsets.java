class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans = new ArrayList<>();
        Map<Character, Integer> maxFreqMap = new HashMap<>();
        for (String word : words2) {
            int[] freq = new int[26];
            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                char key = (char) ('a' + i);
                if (freq[i] > 0) {
                    maxFreqMap.put(key, Math.max(maxFreqMap.getOrDefault(key, 0), freq[i]));
                }
            }
        }
        for (String word : words1) {
            int[] freq = new int[26];
            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }
            boolean isUniversal = true;
            for (Map.Entry<Character, Integer> entry : maxFreqMap.entrySet()) {
                char key = entry.getKey();
                int requiredFreq = entry.getValue();
                if (freq[key - 'a'] < requiredFreq) {
                    isUniversal = false;
                    break;
                }
            }
            if (isUniversal) {
                ans.add(word);
            }
        }
        return ans;
    }
}

