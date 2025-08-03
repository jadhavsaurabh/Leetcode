class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int maxSum = nums[0];
        int currMaxSum = 0;
        int minSum = nums[0];
        int currMinSum = 0;
        int total = 0;


        for (int num : nums) {
            currMaxSum = Math.max(num, currMaxSum + num);
            maxSum = Math.max(currMaxSum, maxSum);

            currMinSum = Math.min(num, currMinSum + num);
            minSum = Math.min(currMinSum, minSum);

            total += num;
        }

        if(maxSum < 0) return maxSum;
        return Math.max(maxSum, total - minSum);
    }
}
