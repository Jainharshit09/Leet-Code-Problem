// i that people of [i] is always in limit people[i]<=limit
// need to find min boat required to every given persom
//for i am thinking can we sort the people in increasing order
//like take 2 pointer start and end 
// if we take first and last weight in the limit means we can directly say we take that and amd move i++ and j++ if weight and increase the boat++ is more than limit than decrease the j-- and increase boat count
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int boat=0;
        Arrays.sort(people);
        int start=0;
        int end=people.length-1;
        while(start<=end){
            if(people[start]+people[end]<=limit){
                boat++;
                start++;
                end--;
            }
            else{
                end--;
                boat++;
            }
        }
        return boat;
    }
}