class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);

        for (int num : nums) {
            Map<Integer, Integer> nextDp = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : dp.entrySet()) {
                int curSum = entry.getKey();
                int count = entry.getValue();

                // add
                nextDp.put(curSum + num, nextDp.getOrDefault(curSum + num, 0) + count);
                // subtract
                nextDp.put(curSum - num, nextDp.getOrDefault(curSum - num, 0) + count);
            }
            dp = nextDp;
        }

        return dp.getOrDefault(target, 0);
    }
}
