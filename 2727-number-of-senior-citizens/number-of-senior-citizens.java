class Solution {
    public int countSeniors(String[] details) {
        int count=0;
        for(String ans:details){
            int second=ans.charAt(11)-'0';
            int first=ans.charAt(12)-'0';
            int age=second*10+first;
            if(age>60){
                count++;
            }
        }
        return count;
    }
}