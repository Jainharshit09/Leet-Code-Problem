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
        int arr[]=new int[mid+1];
        for(int i=0;i<=mid;i++){
            arr[i]=order[i];
        }
        long nonstar=0;
        int start=0;
        Arrays.sort(arr);
        // finding non-star substring from left side
        for(int x:arr){
            long len=x-start;
            nonstar+=(len*(len+1))/2;
            //it will find next point after *
            start=x+1;
        }
        // after last * how mamy remaining substring will there means on right side 
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