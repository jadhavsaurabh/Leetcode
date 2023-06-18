/*
At every element have a choice on including that number or move on
*/
class Solution {
    public static void addSubset(int[] nums, ArrayList<Integer> ls, int idx, List<List<Integer>> res) {
        if(idx >= nums.length) {
            res.add(new ArrayList<>(ls));
            return;
        };

        ls.add(nums[idx]);
        addSubset(nums, ls, idx + 1, res);
        ls.remove(ls.size() -1);
        addSubset(nums, ls, idx + 1, res);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        addSubset(nums, new ArrayList<>(), 0, res);
        return res;
    }
}
