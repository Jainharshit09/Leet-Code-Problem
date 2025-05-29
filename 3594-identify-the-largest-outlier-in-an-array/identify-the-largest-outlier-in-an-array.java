class Solution {
    public int getLargestOutlier(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int sum=0;
        //finding the total sum and store in map every element;
        for(int a:nums){sum+=a;
        map.put(a,map.getOrDefault(a,0)+1);
        }
        int ans=Integer.MIN_VALUE;
        for(int a:nums){
            //take a curr element as a outlier
            int curr_outlier=a;
            map.put(curr_outlier,map.getOrDefault(curr_outlier,0)-1);
            //acc to equation 2x+y=sum  why 2x given sum of n-2 element is sum of one elemet
            int temp=sum-curr_outlier;
            // temp is even not odd 
            if(temp%2==0){
                temp/=2;
                if(map.containsKey(temp) && map.get(temp)>0){ans=Math.max(ans,curr_outlier);}
            }
            map.put(curr_outlier,map.getOrDefault(curr_outlier,0)+1);
        }
        return ans;
    }
}