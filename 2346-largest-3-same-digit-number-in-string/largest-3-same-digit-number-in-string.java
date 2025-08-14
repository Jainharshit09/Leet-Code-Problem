class Solution {
    int n;
    public boolean check(char arr[],int index){
        return index + 2 < arr.length &&
           arr[index] == arr[index + 1] &&
           arr[index + 1] == arr[index + 2];
    }
    public String largestGoodInteger(String num) {
        String result="";
        char arr[]=num.toCharArray();
        n=arr.length;
        int current_max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int number=arr[i]-'0';
            if(check(arr,i) && current_max<number){
                String curr=""+arr[i] + arr[i] + arr[i];
                result=curr;
                current_max=number;
            }
        }
        return result;
    }
}