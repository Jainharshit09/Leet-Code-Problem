class Solution {
    private int convertArrayToNumber(int[] arr) {
        StringBuilder result = new StringBuilder();
        for (int digit : arr) {
            result.append(digit);
        }
        return Integer.parseInt(result.toString());
    }

    public int maximumSwap(int num) {
        String s = Integer.toString(num);
        int n = s.length();
        int[] maxRight = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            maxRight[i] = Character.getNumericValue(s.charAt(i));
            map.put(maxRight[i], i);
        }
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = maxRight[i];
        }
        Arrays.sort(arr, Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            if (maxRight[i] != arr[i]) {
                int value = map.get(arr[i]);
                int temp = maxRight[i];
                maxRight[i] = maxRight[value];
                maxRight[value] = temp;
                return convertArrayToNumber(maxRight);
            }
        }
        return num;
    }
}