//intial score 0
//max total score and 
//power is at least token[i] lost token gain 1 score
//curr score at least 1 gain token and lost 1 score
//like score is small we need add some power so we think need max power to play more game ans loose min score that why sort the array
// sort the array
//play with current token i yes than decrease the token and increase score
//if curr token is small need more power to play than go j index token add that power and play but decrase the score
//i<j this condition we say no more token is there for play
class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        //intial score is zero
        int score=0;
        // new to max ans what we get 
        int count =0;
        //base case
        if(tokens.length==0 || power<0)return 0;
        //size of tokens array
        int n=tokens.length;
        Arrays.sort(tokens);
        int start=0;
        int end=n-1;


        while(start<=end){
            //checking we can do face-up if power is larger than token than we play and increase our score
            //in score we add max possible score possible
            //in increase the start and decrease the power
            if(power>=tokens[start]){
                count++;
                power-=tokens[start];
                score=Math.max(score,count);
                start++;
            }
            // if count is zero than not possible not way to get a good answer so we need check count value is>=1 than we can power and decrease the count
            else if(count>=1){
                power+=tokens[end];
                count--;
                end--;
            }
            
            //in starting count is zero and  tokens = [100], power = 50 in that case we retuen zero
            else{
                return score;
            }
        }
        return score;
    }
}