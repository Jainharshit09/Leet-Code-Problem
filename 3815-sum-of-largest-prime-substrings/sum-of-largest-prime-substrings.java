class Solution {
    public boolean isPrime(long x){
        if(x<2){
            return false;
        }
        for(long i=2;i*i<=x;i++){
            if(x%i==0){return false;}
        }
        return true;
    }
    public long sumOfLargestPrimes(String s) {
        Set<Long>set=new HashSet<>();
        int m=s.length();
        for(int i=0;i<m;i++){
          for(int j=i+1;j<=m;j++){
            String sub = s.substring(i,j);
            long num = Long.parseLong(sub);
            set.add(num);
          }
        }
        List<Long>prime=new ArrayList<>();
        for(long x:set){
            if(isPrime(x)){
                prime.add(x);
            }
        }
        Collections.sort(prime,(a,b)->Long.compare(b,a));
        long ans=0;
        if (prime.size() == 0) return 0;
        if(prime.size()==1){
            return prime.get(0);
        }
        if(prime.size()==2){
            return prime.get(0)+prime.get(1);
        }
        return  prime.get(0)+prime.get(1)+prime.get(2);
    }
}