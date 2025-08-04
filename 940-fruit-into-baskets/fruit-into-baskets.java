// like need max 2 types of fruit we store at a time
// make sure in continous
// observation
// for continous we can go with silding window
// we store fruit in map  and map.size()>=3 than remove till map.size()<=2 till remove i element and at the 
//ans=Max(j-i)
// overall it is combination of hashmap and silding window
class Solution {
    public int totalFruit(int[] fruits) {
        int result=Integer.MIN_VALUE;
        HashMap<Integer,Integer>map=new HashMap<>();
        int i=0;
        int j=0;
        int n=fruits.length;
        while(j<n){
            map.put(fruits[j],map.getOrDefault(fruits[j],0)+1);
            while(map.size()>=3){
                map.put(fruits[i],map.getOrDefault(fruits[i],0)-1);
                if(map.get(fruits[i])==0)map.remove(fruits[i]);
                i++;
            }
            result=Math.max(j-i+1,result);
            j++;
        }
        return result;
    }
}