class Solution {
    private String sortDigits(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        Arrays.sort(arr);
        return new StringBuilder().append(arr).toString();
    }
    public boolean reorderedPowerOf2(int n) {
        String curr=sortDigits(n);
        for(int p=0;p<=29;p++){
            String power=sortDigits(1<<p);
            if(curr.equals(power))return true;
        }
        return false;
    }
}