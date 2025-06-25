// basic approach is used binary search on product
//compare how much value is po
class Solution {
    public long findCountSmallest(int []nums1,int nums2[] ,long midProduct){
        int n=nums2.length;
        long productCount=0;
        for(int i=0;i<nums1.length;i++){
            if(nums1[i]>=0){
                int l=0;
                int r=n-1;
                int m=-1; // invalid on left side
                while(l<=r){
                    int mid=l+(r-l)/2;
                    long product=1L * nums1[i]*nums2[mid];
                    if(product<=midProduct){
                        m=mid;
                        l=mid+1;
                    }else{
                        r=mid-1;
                    }
                }
                productCount+=(m+1);
            }
            else{
                //product will be negative and right hand side will contain smaller products than left habd side larger product
                int l=0;
                int r=n-1;
                int m=n;  //invalid on right side 
              while(l<=r){
                    int mid=l+(r-l)/2;
                    long product=1L*nums1[i]*nums2[mid];
                    if(product<=midProduct){
                        m=mid;
                        r=mid-1;
                    }else{
                        l=mid+1;
                    }
                }
                productCount+=(n-m);
            }
        }
        return productCount;
    }
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long result=0;
        long l=(long)-1e10;
        long h=(long)1e10;
        while(l<=h){
            long mid=l+(h-l)/2;
            long countSmallest=findCountSmallest(nums1,nums2,mid);
            if(countSmallest>=k){
                result=mid;
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return result;
    }
}