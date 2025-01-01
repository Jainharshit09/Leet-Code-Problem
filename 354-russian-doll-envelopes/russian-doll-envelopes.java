
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        ArrayList<Integer> lis = new ArrayList<>();
        for (int[] envelope : envelopes) {
            int height = envelope[1];
            int pos = Collections.binarySearch(lis, height);
            if (pos < 0) pos = -(pos + 1);
            if (pos == lis.size()) lis.add(height);
            else lis.set(pos, height);
        }
        return lis.size();
    }
}
