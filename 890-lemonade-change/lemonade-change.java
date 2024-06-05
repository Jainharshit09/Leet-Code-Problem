class Solution {
    public boolean lemonadeChange(int[] arr) {
        int ans[]=new int[3];
        for(int i=0;i<arr.length;i++){
            if(arr[i]==5){
                ans[0]++;
            }
            else if(arr[i]==10){
                if (ans[0] == 0) {
                    return false;
                }
                    ans[0]--;
                    ans[1]++;
            }
            else if(arr[i]==20){
                if (ans[1] > 0 && ans[0] > 0) {
                    ans[1]--;
                    ans[0]--;
                }
               else if (ans[0] >= 3) {
                    ans[0] -= 3;
                } else {
                    return false;
                }
                ans[2]++;
            }
        }
        return true;
    }
}