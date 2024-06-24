

class Solution {
    public int find(int parent[], int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]); // path compression
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
        
        // Step 1: Initialize parent and rank arrays
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
            names.add(accounts.get(i).get(0)); // add names to the list
        }
        
        // Step 2: Union-find to group accounts by common emails
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
        
        // Step 3: Construct the result
        HashMap<Integer, TreeSet<String>> mergedAccounts = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            int root = find(parent, i);
            TreeSet<String> emailSet = mergedAccounts.getOrDefault(root, new TreeSet<>());
            List<String> account = accounts.get(i);
            emailSet.addAll(account.subList(1, account.size()));
            mergedAccounts.put(root, emailSet);
        }
        
        List<List<String>> ans = new ArrayList<>();
        
        for (int root : mergedAccounts.keySet()) {
            List<String> emailList = new ArrayList<>(mergedAccounts.get(root));
            Collections.sort(emailList); // sort emails as required
            String name = names.get(root);
            List<String> entry = new ArrayList<>();
            entry.add(name);
            entry.addAll(emailList);
            ans.add(entry);
        }
        
        return ans;
    }
}
