class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        combine(candidates, target, 0, 0, new ArrayList<>(), res);
        return res;
    }

    void combine(int[] candidates, int target, int idx, int sum, List<Integer> ls, List<List<Integer>> res) {
        if (sum == target) {
            res.add(new ArrayList<>(ls));
            return;
        }
        if (idx >= candidates.length || sum > target) return;

        int i = idx;
        while (i < candidates.length) {
            if (i > idx && candidates[i] == candidates[i - 1]) {
                i++;
                continue;
            }

            ls.add(candidates[i]);
            combine(candidates, target, i + 1, sum + candidates[i], ls, res);
            ls.removeLast();
            i++;
        }
    }
}
