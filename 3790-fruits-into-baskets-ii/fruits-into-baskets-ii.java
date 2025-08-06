//using segment tree we can solve;


class Solution {
    public void buildTree(long seg[],int i,int l,int r, int arr[]){
        if(l==r){
            seg[i]=arr[l];
            return;
        }
        int mid=l+(r-l)/2;
        buildTree(seg,2*i+1,l,mid,arr);
        buildTree(seg,2*i+2,mid+1,r,arr);
        seg[i]=Math.max(seg[2*i+1],seg[2*i+2]);
    }
    public int query(long seg[],int i,int l,int r,int val){
        if(seg[i]<val)return -1;
        if(l==r)return l;
        int mid=l+(r-l)/2;
        //go left first than check ans is possible than return from there if no than go to right
        int left=query(seg,2*i+1,l,mid,val);
        if(left!=-1)return left;
        return query(seg,2*i+2,mid+1,r,val);
    }
    public void update(long seg[],int i,int l,int r,int index){
        if(l==r){
            seg[i]=0;
            return;
        }
         int mid=l+(r-l)/2;
         if(index<=mid){
            update(seg,2*i+1,l,mid,index);
         }
         else{
            update(seg,2*i+2,mid+1,r,index);
         }
         seg[i]=Math.max(seg[2*i+1],seg[2*i+2]);
    }
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n=baskets.length;
        int unplaced=0;
        long seg[]=new long[4*n];
        buildTree(seg,0,0,n-1,baskets);
        for(int fruit:fruits){
            int queryIndex=query(seg,0,0,n-1,fruit);
            if(queryIndex!=-1){
                update(seg,0,0,n-1,queryIndex);
            }
            else{
                unplaced++;
            }
        }
        return unplaced;
    }
}