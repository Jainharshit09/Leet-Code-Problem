class Solution {
    public int findSum(int n){
        int sum=0;
        while(n>0){
            sum+=n%10;
            n/=10;
        }
        return sum;
    }
    public int countLargestGroup(int n) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int maxSize=0;
        int count=0;
        for(int num=1;num<=n;num++){
            int digitSum=findSum(num);
            map.put(digitSum,map.getOrDefault(digitSum,0)+1);
            if(map.get(digitSum)==maxSize){
                count++;
            }
            else if(map.get(digitSum)>maxSize){
                maxSize=map.get(digitSum);
                count=1;
            }
        }
        return count;
    }
}