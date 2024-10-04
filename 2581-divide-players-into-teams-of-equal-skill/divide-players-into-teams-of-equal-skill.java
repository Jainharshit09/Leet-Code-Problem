class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        if (n % 2 != 0) {
            return -1;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += skill[i];
        }
        int target = sum / (n / 2);
        if (sum % (n / 2) != 0) {
            return -1;
        }
        Arrays.sort(skill);
        int k = 0;
        int j = n - 1;
        long ans = 0;
        while (k < j) {
            if(skill[k] + skill[j] != target){
                return -1;
            }
            long value = skill[k] * skill[j];
            ans += value;
            k++;
            j--;
        }
        return ans;
    }
}