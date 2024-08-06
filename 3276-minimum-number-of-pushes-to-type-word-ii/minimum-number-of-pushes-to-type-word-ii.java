class Pair implements Comparable<Pair> {
    char ch;
    int count;

    public Pair(char ch, int count) {
        this.ch = ch;
        this.count = count;
    }

    @Override
    public int compareTo(Pair p) {
        return p.count - this.count; 
    }
}

class Solution {
    public int minimumPushes(String word) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        List<Pair> pairs = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pairs.add(new Pair(entry.getKey(), entry.getValue()));
        }
        Collections.sort(pairs);

        int minPushes = 0;
        int pushCount = 1;
         int assignedChars = 0;

        for (Pair p : pairs) {
            minPushes += pushCount * p.count;
             assignedChars++;
             if (assignedChars % 8 == 0) {
                pushCount++;
            }
        }

        return minPushes;
    }
}