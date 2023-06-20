/*
Try out every combination
*/
class Solution {
    public static void findSumSet(List<List<Integer>> result, int[] candidates, int id, List<Integer> ls, int target, int sumSoFar) {
        if(sumSoFar > target) return;
        if(id >= candidates.length) {
            if(sumSoFar == target) {
                result.add(new ArrayList<>(ls));
            }
            return;
        }
        ls.add(candidates[id]);
        sumSoFar += candidates[id];
        findSumSet(result, candidates, id, ls, target, sumSoFar);
        var removed = ls.remove(ls.size() - 1);
        sumSoFar -= removed;
        findSumSet(result, candidates, id + 1, ls, target, sumSoFar);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        findSumSet(result, candidates, 0, new ArrayList<>(), target, 0);
        return result;
    }
}
