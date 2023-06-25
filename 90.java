/*
  Sort & skip elements similar to three sum problem
*/
class Solution {
    public static void recurse(int[] nums, List<List<Integer>> res, List<Integer> ls, int id) {
        if(id == nums.length) {
            res.add(new ArrayList<>(ls));
        } else {
            ls.add(nums[id]);
            recurse(nums, res, ls, id + 1);
            ls.remove(ls.size() - 1);
            while(id + 1 < nums.length && nums[id] == nums[id + 1]) {
                id++;
            }
            recurse(nums, res, ls, id + 1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int id = 0;
        recurse(nums, res, new ArrayList<>(), id);
        return res;
    }
}
