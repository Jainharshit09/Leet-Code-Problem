//calculate a unique element 
// from that we can say ki we need to wait for n mintiues
//like if we taking element than n+1 element we need to add
// we can take element store in list pop decrease there freq by 
// in end like pq will be empty than directly and ans+=list.size()
// other wise time will be required n+1 everytime

// in which heap+ greedy we need to think



class Solution {
    public int leastInterval(char[] tasks, int n) {
        int []map=new int[26];
        int m=tasks.length;
        for(int i=0;i<m;i++){
            map[tasks[i]-'A']++;
        }
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        int ans=0;
        for(int i=0;i<26;i++){
            if(map[i]!=0)pq.add(map[i]);
        }

       
        while(!pq.isEmpty()){
            List<Integer>list=new ArrayList<>();
            for(int i=1;i<=n+1;i++){
               if(!pq.isEmpty()){
                 int freq=pq.poll();
                 freq--;
                 list.add(freq);
               }
            }
            for(int i=0;i<list.size();i++){
                if(list.get(i)!=0){
                    pq.add(list.get(i));
                }
            }
            if(pq.isEmpty())ans+=list.size();
            else {
                ans+=(n+1);
                System.out.print(ans);
            }
        }
        return ans;
    }
}