class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, new ArrayList<>(), 0, candidates, target, res);
        return res;
    }

    private void dfs(int i, List<Integer> cur, int total, int[] candidates, int target, List<List<Integer>> res) {
        if (total == target) {
            res.add(new ArrayList<>(cur)); // Make a copy
            return;
        }

        if (i >= candidates.length || total > target) {
            return;
        }

        // Include current candidate
        cur.add(candidates[i]);
        dfs(i, cur, total + candidates[i], candidates, target, res);
        cur.remove(cur.size() - 1); // Backtrack

        // Exclude current candidate and move to next
        dfs(i + 1, cur, total, candidates, target, res);
    }
}
