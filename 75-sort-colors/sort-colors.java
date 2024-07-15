class Solution {
    public void sortColors(int[] arr) {
        // for(int turns=0;turns<arr.length;turns++){
        //     for(int j=0;j<arr.length-1-turns;j++){
        //         if(arr[j]>arr[j+1]){
        //             int temp=arr[j];
        //             arr[j]=arr[j+1];
        //             arr[j+1]=temp;
        //           }
        //     }
        // }
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i],1);
            }
            else{
                map.put(arr[i],map.get(arr[i])+1);
            }
        }
        int index=0;
        for(int i=0;i<3;i++){
            if(map.containsKey(i)){
                int count=map.get(i);
                for(int j=0;j<count;j++){
                    arr[index++]=i;
                }
            }
        }
    }
}