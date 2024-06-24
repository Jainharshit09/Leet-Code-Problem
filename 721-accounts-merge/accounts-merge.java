

class Solution {
    public int find(int parent[], int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]); 
        }
        return parent[x];
    }
    
    public void union(int parent[], int rank[], int x, int y) {
        int root_i = find(parent, x);
        int root_j = find(parent, y);
        if (root_i != root_j) {
            if (rank[root_i] > rank[root_j]) {
                parent[root_j] = root_i;
            } else if (rank[root_i] < rank[root_j]) {
                parent[root_i] = root_j;
            } else {
                parent[root_j] = root_i;
                rank[root_i]++;
            }
        }
    }
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        int[] parent = new int[n];
        int[] rank = new int[n];
        HashMap<String, Integer> mail = new HashMap<>();
        List<String> names = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
            names.add(accounts.get(i).get(0));
        }
        
        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);
            List<String> emails = account.subList(1, account.size());
            for (String email : emails) {
                if (!mail.containsKey(email)) {
                    mail.put(email, i);
                } else {
                    int existingIndex = mail.get(email);
                    union(parent, rank, i, existingIndex);
                }
            }
        }
        ArrayList<String>[] mergedmail=new ArrayList[n];
        for(int i=0;i<n;i++){
            mergedmail[i]=new ArrayList<>();
            for(Map.Entry<String,Integer> it:mail.entrySet()){
                String email=it.getKey();
                int node=it.getValue();
                 if (find(parent, node) == i){
                     mergedmail[i].add(email);
                }
            }
        }
    List<List<String>> ans=new ArrayList<>();
    for (int i = 0; i < n; i++) {
        if (mergedmail[i].size() == 0) continue;
        Collections.sort(mergedmail[i]);
        List<String> nameAndEmails = new ArrayList<>();
        nameAndEmails.add(accounts.get(i).get(0));
        nameAndEmails.addAll(mergedmail[i]);
        ans.add(nameAndEmails);
        }
        return ans;
    }
}
