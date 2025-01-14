class Solution {
    public boolean isValidSerialization(String preorder) {
        int ans=1;
        preorder+=',';
        int n=preorder.length();
        for(int i=0;i<n;i++){
            char ch=preorder.charAt(i);
            if(ch==','){
                ans--;
             if(ans<0){
                return false;
            }
                if(preorder.charAt(i-1)!='#')ans+=2;
            }
        }
        return ans==0;
    }
}