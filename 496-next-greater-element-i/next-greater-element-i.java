class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int ans[]=new int [n];
        int m=nums2.length;
        HashMap<Integer,Integer>map=new HashMap<>();
        Stack<Integer>s=new Stack<>();
        for(int i=m-1;i>=0;i--){
            while(!s.isEmpty() && nums2[s.peek()]<=nums2[i]) s.pop();
            if(s.isEmpty()) map.put(nums2[i],-1);
            else{
                map.put(nums2[i],nums2[s.peek()]);
            }
            s.push(i);
        }
        for(int i=0;i<n;i++){
            ans[i]=map.get(nums1[i]);

        }
        return ans;
    }
}