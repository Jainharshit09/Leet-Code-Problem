// find palindron number than check it base k is also
// for finding palindron we can find the length
// for even we can take reverse of that and add in the number
// for odd need make reverse remove first element then add in the number will give palindron
// length+1/2 find pal for both even and odd
// we can find min and max range min for 10^(L-1) and max will 10^(L) -1
//after finding the pal check it is also pal of base k or not if yes thab n-- sum+=pal 
// time complexity is finding palindron 10^D+1/2 * (D+logn) where d is digti or number

class Solution {
    public boolean isPalindrome(String baseK){
        int left=0;
        int right=baseK.length()-1;
        while(left<=right){
            if(baseK.charAt(left)!=baseK.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public String convertToBaseK(long planNum,int k){
         if (planNum==0){
            return "0";
         }
         StringBuilder result=new StringBuilder();
         while(planNum>0){
            result.append(planNum%k);
            planNum/=k;
         }
         return result.toString();
    }
    public long kMirror(int k, int n) {
        long length=1;
        long sum=0;
        while(n>0){
            long halfLenght=(length+1)/2;
            long minNum=(long)Math.pow(10,halfLenght-1);
            long maxNum=(long)Math.pow(10,halfLenght)-1;
            for(long num=minNum;num<=maxNum;num++){
                String firstHalf=Long.toString(num);
                String secondHalf= new StringBuilder(firstHalf).reverse().toString();
                String palindron;
                if(length%2==0){
                    palindron=firstHalf+secondHalf;
                }
                else{
                    palindron=firstHalf+secondHalf.substring(1);
                }
                long planNum=Long.parseLong(palindron);
                String baseK=convertToBaseK(planNum,k);
                if(isPalindrome(baseK)){
                    sum+=planNum;
                    n--;
                }
                if(n==0){
                    break;
                }
            }
            length++;
        }
        return sum;
    }
}