class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int indegree[]=new int[numCourses];
        for(int[]arr:prerequisites){
                indegree[arr[0]]++;
            
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int count=0;
        while(!q.isEmpty()){
            int curr=q.poll();
            count++;
              for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == curr) {
                    if (--indegree[prerequisite[0]] == 0) {
                        q.add(prerequisite[0]);
                    }
                }
            }
        }
        if(count==numCourses){
            return true;
        }
        return false;
    }
}