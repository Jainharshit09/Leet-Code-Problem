class Solution {
public:
    int maxProfitAssignment(vector<int>& difficulty, vector<int>& profit, vector<int>& worker) {
        int n=difficulty.size();
        int m=worker.size();
        priority_queue<pair<int,int>> pq;
        for(int i=0;i<n;i++){
            int diff=difficulty[i];
            int prt=profit[i];
            pq.push({prt,diff});
        }
        sort(begin(worker),end(worker),greater<int>());
        int i=0;
        int ans=0;
        while(i<m && !pq.empty()){
            if(pq.top().second>worker[i]){
                pq.pop();
            }
            else{
                ans+=pq.top().first;
                i++;
            }
         }
         return ans;
    }
};