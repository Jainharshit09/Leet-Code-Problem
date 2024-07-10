class Solution {
    public int minOperations(String[] logs) {
        Stack<String> s=new Stack<>();
        for(String log:logs){
             if (log.equals("../")) {
                if (!s.isEmpty()) {
                    s.pop();
                }
             }
            else if(!log.equals("./")){
                s.push(log);
            }
        }
        return s.size();
    }
}