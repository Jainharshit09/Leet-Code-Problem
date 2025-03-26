class Solution {
    public int nckMod10(int n,int k){
        int mod2=nckLuccaMod2(n,k);
        int mod5=nckLuccaMod5(n,k);
        for(int i=0;i<10;i++){
            if(i%2==mod2 && i%5==mod5){
                return i;
            }
        }
        return 0;
    }

    public int nckLuccaMod2(int n,int k){
       int result=1;
       while(n>0 || k>0){
             int ndigit=n%2;
             int kdigit=k%2;
             if(kdigit>ndigit){
                return 0;
             }
             result=(result*nck2(ndigit,kdigit))%2;
             n/=2;
             k/=2;
       }
       return result;
    }

    public int nck2(int n,int k){
        if(k>n){
            return 0;
        }
        return 1;
    }

    public int nckLuccaMod5(int n,int k){
        int result=1;
        while(n>0 || k>0){
             int ndigit=n%5;
             int kdigit=k%5;
             if(kdigit>ndigit){
                return 0;
             }
             result=(result*nck5(ndigit,kdigit))%5;
             n/=5;
             k/=5;
        }
        return result;
    }

  public int nck5(int n, int k) {
        if (k > n) {
            return 0;
        }
        int[] factorialMod5 = {1, 1, 2, 1, 4};
        int numerator = factorialMod5[n];
        int denominator = (factorialMod5[k] * factorialMod5[n - k]) % 5;
        int denominatorInverse = 0;
        for (int candidate = 0; candidate < 5; candidate++) {
            if ((denominator * candidate) % 5 == 1) {
                denominatorInverse = candidate;
                break;
            }
        }
        return (numerator * denominatorInverse) % 5;
    }

    public boolean hasSameDigits(String s) {
        int n=s.length()-2;
        int weightSumFirst=0;
        int weightSumSecond=0;
        for(int i=0;i<=n;i++){
            int coff=nckMod10(n,i);
            int d=s.charAt(i)-'0';
            int d1=s.charAt(i+1)-'0';
            weightSumFirst=(weightSumFirst+coff*d)%10;
            weightSumSecond=(weightSumSecond+coff*d1)%10;
        }
        return weightSumFirst==weightSumSecond;
    }
}