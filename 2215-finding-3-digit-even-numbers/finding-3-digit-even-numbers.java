class Solution {
    public int[] findEvenNumbers(int[] digits) {
        ArrayList<Integer>ans=new ArrayList<>();
        int count[]=new int[10];
        for(int i=0;i<digits.length;i++){
           count[digits[i]]++;
        }
        for(int i =1;i<=9;i++){
            if(count[i]==0)continue;
           count[i]--;
            for(int j=0;j<=9;j++){
                 if(count[j]==0)continue;
                 count[j]--;
                for(int k=0;k<=8;k+=2){
                    if(count[k]==0)continue;
                    count[k]--;
                    int temp=i*100+j*10+k;
                    ans.add(temp);
                    count[k]++;
                }
                count[j]++;
            }
            count[i]++;
        }
        int result[]=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            result[i]=ans.get(i);
        }
        return result;
    }
}