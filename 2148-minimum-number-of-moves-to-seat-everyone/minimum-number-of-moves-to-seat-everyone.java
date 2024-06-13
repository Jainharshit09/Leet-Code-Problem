class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
       int st[]=new int[101];
       int sa[]=new int[101];
       for(int i=0;i<seats.length;i++){
        int k=seats[i];
        sa[k]=sa[k]+1;
        int j=students[i];
        st[j]=st[j]+1;
       }
       int ans=0;
       int i=0;
       int j=0;
       while(i<sa.length && j<st.length){
        while(i<sa.length && sa[i]==0){
            i++;
        }
        while(j<st.length && st[j]==0){
            j++;
        }
        if (i >= sa.length || j >= st.length) {
                break;
            }

        int moves=Math.min(sa[i],st[j]);
        ans+=moves*Math.abs(i - j);
        sa[i]-=moves;
        st[j]-=moves;
     }
     return ans;
  }
}