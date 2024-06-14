class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
         int indegree[]=new int[numCourses];
        for(int[]arr:prerequisites){
                indegree[arr[0]]++;
            
        }
         int count=0;
         ArrayList<Integer> result=new ArrayList<>();
       Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
                count++;
                result.add(i);
            }
        }
         while(!q.isEmpty()){
            int curr=q.poll();
              for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == curr) {
                    if (--indegree[prerequisite[0]] == 0) {
                        q.add(prerequisite[0]);
                        count++;
                        result.add(prerequisite[0]);
                    }
                }
            }
        }
        if (result.size() == numCourses) {
            int[] ans = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                ans[i] = result.get(i);
            }
            return ans;
        }
        return new int[0]; 
    }
}