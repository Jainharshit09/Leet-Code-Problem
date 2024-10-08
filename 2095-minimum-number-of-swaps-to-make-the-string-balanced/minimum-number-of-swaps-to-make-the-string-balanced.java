class Solution {
    // public static boolean isValidString(char[] chars) {
    //     Stack<Character> stack = new Stack<>();
    //     for (char ch : chars) {
    //         if (ch == '[') {
    //             stack.push(ch);
    //         } else if (ch == ']') {
    //             if (stack.isEmpty()) {
    //                 return false;
    //             }
    //             stack.pop();
    //         }
    //     }
    //     return stack.isEmpty();
    // }
    public int minSwaps(String s) {
        // char[] chars = s.toCharArray();
        // int i = 0;
        // int j = s.length() - 1;
        // int count = 0;
        // while (i < j && isValidString(chars) == false) {
        //     char start = chars[i];
        //     char end = chars[j];
        //     if (start != '[' && end != ']') {
        //         chars[i] = end;
        //         chars[j] = start;
        //         count++;
        //         i++;
        //         j--;
        //     } else {
        //         if (start == '[') {
        //             i++;
        //         }
        //         if (end == ']') {
        //             j--;
        //         }
        //     }
        // }
        // return count;

        int open=0;
        int close=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='['){
                open++;
            }
            else{
                if(open>0){
                    open--;
                }
                else{
                    close++;
                }
            }
        }
        return (close+1)/2;
    }
}