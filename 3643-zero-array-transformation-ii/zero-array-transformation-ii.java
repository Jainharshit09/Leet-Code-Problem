class Solution {
    int n;
    int q;

    public boolean check(int nums[], int queries[][], int k) {
        int[] diff = new int[n];
        for (int i = 0; i <= k; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int x = queries[i][2];
            diff[l] += x;
            if (r + 1 < n)
                diff[r + 1] -= x;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += diff[i];
            diff[i] = sum;
            if (nums[i] - diff[i] > 0) {
                return false;
            }
        }
        return true;
    }

    public boolean allZero(int nums[]) {
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public int minZeroArray(int[] nums, int[][] queries) {
        n = nums.length;
        q = queries.length;
        if (allZero(nums)) {
            return 0;
        }
        int l = 0;
        int r = q - 1;
        int k = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if(check(nums,queries,mid)){
                 k = mid + 1; 
                r = mid - 1;
            }
            else{
                l=mid+1;
            }
        }
        return k;
    }
}