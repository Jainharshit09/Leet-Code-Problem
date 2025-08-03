//make a string i index with *
// need to find min time to get k valid substring
// we can do binary search on order
// and check at that time we getting k valid substring 
// if yes than go left side and other wise right side
//now main point how i will count valid substring
// take all 0 to mid+1 index will make it *
// find total-non_star_left-non_star_right at particular point i will get 

class Solution {
    long total;
    public boolean isPossible(String s,int order[],int k,int mid){
        int n=s.length();
        int takeTillMid[]=new int[mid+1];
        for(int i=0;i<=mid;i++){
            takeTillMid[i]=order[i];
        }
        Arrays.sort(takeTillMid);
        long nonstar=0;
        int start=0;
        for(int idx:takeTillMid){
            long len=idx-start;
            nonstar+=(len*(len+1))/2;
            start=idx+1;
        }
        long len=s.length()-start;
        nonstar+=(len*(len+1))/2;
        return (total-nonstar)>=k;

    }
    public int minTime(String s, int[] order, int k) {
        int n=s.length();
        int m=order.length;
        total=(long)n*(n+1)/2;
        int left=0;
        int right=m-1;
        int ans=-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(isPossible(s,order,k,mid)){
                ans=mid;
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return ans;
    }
}