// like 3 children and there position
// for every children there is only n-1 moves
// from previous point for 1st child we can go diagonal because it take n-1 moves 

// now 2nd and thrid child we are having a defines a moves to 
//having choices on 2 nd third like  two points is changing so it will go with 2dp
//but for every child 2 and 3 we are having choice can we go toward with dp 
//create a dp like because 2 pointer are changing i and j i think it is similar to coin
//both children 2 and base will be like if moves==0 and in the curr index a n-1 tham means it is possble return 0 other wise return -1 because not possible in ans we check if we get -1 
// another point is like if children 2 go beyond the diagonal than we will no go n-1 so means children only travel in upper diagonal and for same child 3 lower triangle 

//in child 2 conditon is that if always i is greater than j

// in child 3 condition j is greater than i 

class Solution {
    //for child2
    int n;
    int dp[][];
    public int getChild2(int i,int j,int fruit[][]){
        if(j>=n || i>=n || j<0)return 0;
        if(i==n-1 && j==n-1)return 0;
        if(i>=j)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int bottomLeft=fruit[i][j]+getChild2(i+1,j-1,fruit);
        int bottomDown=fruit[i][j]+getChild2(i+1,j,fruit);
        int bottomRight=fruit[i][j]+getChild2(i+1,j+1,fruit);
        return  dp[i][j]=Math.max(bottomLeft,Math.max(bottomDown,bottomRight));
    }

    //for child 3
    public int getChild3(int i,int j,int fruit[][]){
        if(j>=n || i>=n || j<0)return 0;
        if(i==n-1 && j==n-1)return 0;
        if(i<=j)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int next=fruit[i][j]+getChild3(i,j+1,fruit);
        int top_right=fruit[i][j]+getChild3(i-1,j+1,fruit);
        int bottom_right=fruit[i][j]+getChild3(i+1,j+1,fruit);
        return dp[i][j]= Math.max(next,Math.max(top_right,bottom_right));
    }


    public int maxCollectedFruits(int[][] fruits) {
        n=fruits.length;
        dp=new int[n][n];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        int child1=0;
        //for 1st child 
        for(int i=0;i<n;i++){
            child1+=fruits[i][i];
        }

        int child2=getChild2(0,n-1,fruits);
        int child3=getChild3(n-1,0,fruits);
        return child1+child2+child3;
    }
}