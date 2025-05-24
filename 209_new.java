class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int l = 0;
        int minlength = Integer.MAX_VALUE;

        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];

            while (sum >= target) {
                minlength = Math.min(minlength, r - l + 1);
                sum -= nums[l];
                l++;
            }
        }

        return minlength == Integer.MAX_VALUE ? 0 : minlength;
    }
}
