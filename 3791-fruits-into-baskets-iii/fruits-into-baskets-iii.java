//brute force will not work because of time constraint
//need to optimize 

// given a array fruit and baskets
// like need to check first from left one than go to write one
// can we use segment tree

// like create a segement tree of basket
// make sure in left ans is possible than go left otherwise go right if find the answer than need to update that make it 0

//3->5->4 is given 

//but problem is that at the time of update i know the index which i need to remove no.

class Solution {

    //create A tree;
    public void buildTree(long seg[],int i,int l,int r,int arr[]){
        if(l==r){
            seg[i]=arr[l];
            return;
        }
        int mid=l+(r-l)/2;
        buildTree(seg,2*i+1,l,mid,arr);
        buildTree(seg,2*i+2,mid+1,r,arr);
        seg[i]=Math.max(seg[2*i+1],seg[2*i+2]);
    }

    public int query(long seg[],int val,int index,int start,int end){
        if(seg[index]<val) return -1;
        if(start==end)return start;
        int mid=start+(end-start)/2;
        // try left ans first
        int leftAns=query(seg,val,2*index+1,start,mid);
        if(leftAns!=-1) return leftAns;

        //them right
        return query(seg,val,2*index+2,mid+1,end);
    }


    //now update the tree
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
        long seg[]=new long[4*n];
        int unplaced=0;
        buildTree(seg,0,0,n-1,baskets);
        for(int i=0;i<n;i++){
            int fruit=fruits[i];
            int queryIndex=query(seg,fruit,0,0,n-1);
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



//step 1:build a tree using basket
//step 2:run a loop in fruit take a fruit
//in segment tree we stor max value
//step:3 do a query on that like if we find in left than go left if not than go right
//after finding the answer update call on that and make it zero  update the tree
// if we can't find the answer return -1 and we increase the unplaced++


//yesterday question is also we can solve using that because both question are same only constraint are different in yest. brute force will work



