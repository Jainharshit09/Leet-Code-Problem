// for max traverse left to right and find min value then convert that in 9
// for min we travese form left to right need to check not having leading zero and also check nums[i]!=nums[0] then we can change otherwise not that index do than leading zero will come
class Solution {
    public int maxDiff(int num) {
         String str1 = Integer.toString(num);
        String str2 = str1;
        int n=str1.length();
        // Create max number by replacing first non-9 digit with 9
        int idx = -1;
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) != '9') {
                idx = i;
                break;
            }
        }

        if (idx != -1) {
            char ch = str1.charAt(idx);
            str1 = str1.replace(ch, '9');
        }
        for(int i=0;i<n;i++){
             char ch = str2.charAt(i);
             if(i==0){
                  if (ch != '1') {
                    str2 = str2.replace(ch, '1');
                    break;
                }
             }
             else if(ch != '0' && ch != str2.charAt(0)){
                str2 = str2.replace(ch, '0');
                break;
             }
        }
        return Integer.parseInt(str1) - Integer.parseInt(str2);
    }
}