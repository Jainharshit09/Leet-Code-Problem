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
        int i=0;
        while(map.size()!=0){
            if(map.containsKey(0)){
              int count=map.get(0);
              for(int j=0;j<count;j++){
                 arr[i++]=0;
              }
              map.remove(0);
            }
            else if(map.containsKey(1)){
                 int count=map.get(1);
              for(int j=0;j<count;j++){
                 arr[i++]=1;
              }
              map.remove(1);
            }
            else{
                int count=map.get(2);
              for(int j=0;j<count;j++){
                 arr[i++]=2;
              }
              map.remove(2);
            }

        }
    }
}