class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n = recipes.length;
        boolean[] make = new boolean[n];
        Set<String> set = new HashSet<>(Arrays.asList(supplies));
        List<String> ans = new ArrayList<>();
        int count = n;
        while (count-- > 0) {
            for (int i = 0; i < n; i++) {
                if (make[i]) continue;
                boolean canMake = true;
                for (String ing : ingredients.get(i)) {
                    if (!set.contains(ing)) {
                        canMake = false;
                        break;
                    }
                }
                if (canMake) {
                    ans.add(recipes[i]);
                    set.add(recipes[i]);
                    make[i] = true;
                }
            }
        }
        return ans;
    }
}
