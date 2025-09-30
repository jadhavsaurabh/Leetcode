class Solution {
    public int triangularSum(int[] nums) {
        List<Integer> prev = new ArrayList<>();
        for (int num : nums) {
            prev.add(num);
        }


        List<Integer> curr = new ArrayList<>();
        while(prev.size() > 1) {
            curr = new ArrayList<>();
            for (int i = 0; i < prev.size() - 1; i++) {
                curr.add((prev.get(i) + prev.get(i+1)) % 10);
            }

            prev = curr;
        }
        return prev.get(0);
    }
}
