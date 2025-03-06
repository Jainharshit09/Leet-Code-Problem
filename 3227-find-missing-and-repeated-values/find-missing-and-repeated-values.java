class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length*grid.length;
        int same=0;
        int sum=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int[]arr:grid){
           for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                same=arr[i];
            }
            else{
                map.put(arr[i],1);
                sum+=arr[i];
            }
           }
        }
        sum-=(n*(n+1)/2);
        int result[]=new int[2];
        result[0]=same;
        result[1]=Math.abs(sum);
        return result;
    }
}