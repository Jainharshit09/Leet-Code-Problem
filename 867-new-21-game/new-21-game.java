//starting will be 0
// less than k points
//stop when get more than k
//like we need to p[21]+p[20]+p[19]+p[18]+p[17]
//also intial score is zero than prob[0]=1
// and finding p[16]=p[15]*1/maxpts+p[14]*1/maxts........+ p[i-maxpts (6)]/1/maxpts
// for p[17]=p[16]*1/maxpts+p[15]*1/maxts........+ p[i-maxpts (7)]/1/maxpts
//now from we say that i<k than prev probSum+prob[i]
// and for next remove the i-maxpts from probsum it will not give me prob 
class Solution {
    public double new21Game(int n, int k, int maxPts) {
        double prob[]=new double[n+1];
        prob[0]=1.0;
        double probSum=( k==0) ?0.0 :1.0;
        for(int i=1;i<=n;i++){
            prob[i]=probSum/maxPts;
            if(i<k){
                probSum+=prob[i];
            }
            if(i-maxPts >=0 && i-maxPts<k){
                probSum-=prob[i-maxPts];
            }
        }
        double ans=0.0;
        for(int i=k;i<=n;i++){
            ans+=prob[i];
        }
        return ans;
    }
}