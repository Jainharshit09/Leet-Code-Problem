class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        // int ans=numBottles;
        // while(numBottles>=numExchange){
        //  int divides=numBottles/numExchange;
        // int modulo=numBottles%numExchange;
        // ans+=divides;
        // numBottles=divides+modulo;
        // }
        // return ans;


        return numBottles +(numBottles-1)/(numExchange-1);
    }
}