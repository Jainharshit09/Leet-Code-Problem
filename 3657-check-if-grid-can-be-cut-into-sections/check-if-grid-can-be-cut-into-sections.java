class Solution {
    public int[][] merge(int[][] arr) {
        if(arr.length<=1){
            return arr;
        }
        Arrays.sort(arr,Comparator.comparing(i->i[0]));
        List< int [] > result=new ArrayList<>();
        int [] newinterval=arr[0];
        result.add(newinterval);
        for(int [] interval:arr){
            if(interval[0] < newinterval[1]){
                newinterval[1]=Math.max(newinterval[1],interval[1]);
            }
            else{
                newinterval=interval;
                result.add(newinterval);
            }
        }
        return result.toArray(new int[result.size()][]);
}
    public boolean checkValidCuts(int n, int[][] rectangles) {
        List<int[]> hor = new ArrayList<>();
        List<int[]> vert = new ArrayList<>();
        for(int rect[]:rectangles){
            int x1=rect[0];
            int y1=rect[1];
            int x2=rect[2];
            int y2=rect[3];
            hor.add(new int[]{x1,x2});
            vert.add(new int[]{y1,y2});
        }
        int[][] horArray = hor.toArray(new int[hor.size()][2]);
        int[][] verArray = vert.toArray(new int[vert.size()][2]);

        int result[][]=merge(horArray);
        int result2[][]=merge(verArray);
        return result.length>=3 || result2.length>=3;
    }
}