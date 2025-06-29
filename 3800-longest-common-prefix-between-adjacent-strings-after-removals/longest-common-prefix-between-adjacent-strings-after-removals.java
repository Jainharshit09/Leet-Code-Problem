class Solution {

    private int countPrefix(String a, String b) {
        int len = Math.min(a.length(), b.length());
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) == b.charAt(i))
                count++;
            else
                break;
        }
        return count;
    }

    public int[] longestCommonPrefix(String[] words) {
        int n=words.length;
        int prefix[]=new int[n];
        int suffix[]=new int[n];
        int ans[]=new int[n];
        // calculate the prefix
        int checkPrefix=0;
        for(int i=0;i<n;i++){
            if(i==0){
                prefix[0]=0;
                continue;
            }
            prefix[i]=Math.max(prefix[i-1],checkPrefix);
            checkPrefix=countPrefix(words[i], words[i - 1]);
        }

        //calculate suffix
        int checksuffix=0;
        for(int i=n-1;i>=0;i--){
            if(i==n-1){
                suffix[n-1]=0;
                continue;
            }
            suffix[i]=Math.max(suffix[i+1],checksuffix);
            checksuffix=countPrefix(words[i], words[i+1]);
        }

        // now checking best possible
        for(int i=0;i<n;i++){
            if(i==0 || i==n-1){
                ans[i]=Math.max(suffix[i],prefix[i]);
                continue;
            }
            int adjacent = 0;
            if (i > 0 && i < n - 1) {
                adjacent = countPrefix(words[i - 1], words[i + 1]);
            }
            ans[i]=Math.max(Math.max(prefix[i], suffix[i]), adjacent);
        }
        return ans;
    }
}