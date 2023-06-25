/*
Maintain visted array add mark visited, recurse, pop mark unvisted
*/
class Solution {
    public static void permutate(List<List<Integer>> res, int[] visited, int[] nums, List<Integer> ls) {
        if(ls.size() == nums.length) {
            res.add(new ArrayList<>(ls));
        } else {
            for(int i=0;i<nums.length;i++) {
                if(visited[i] == 0) {
                    visited[i] = 1;
                    ls.add(nums[i]);
                    permutate(res, visited, nums, ls);
                    ls.remove(ls.size() - 1);
                    visited[i] = 0;
                }
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[nums.length];
        permutate(res, visited, nums, new ArrayList<>());
        return res;
    }
}
