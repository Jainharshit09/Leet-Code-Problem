//find 2 max number in that
// than multiply in the end;
class Solution {
    public int maxProduct(int n) {
        int first=0;
        int second=0;
        while(n>0){
            int curr=n%10;
            if(first<curr){
                int t=first;
                first=curr;
                second=t;
            }
            else if(second<curr){
                second=curr;
            }
            n/=10;
        }
        return first*second;
    }
}