class Solution {
    public void permutate(List<List<Integer>> res, boolean[] visited, int[] nums, List<Integer> permutation) {
        if(permutation.size() == nums.length) {
            //System.out.println(permutation);
            res.add(List.copyOf(permutation));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (i> 0 && nums[i] == nums[i-1]  && !visited[i-1]) continue;
                if (!visited[i]) {
                    permutation.add(nums[i]);
                    visited[i] = true;
                    permutate(res, visited, nums, permutation);
                    permutation.removeLast();
                    visited[i] = false;
                }
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        ArrayList<Integer> permutation = new ArrayList<>();
        permutate(res, visited, nums, permutation);
        return res;
    }
}
