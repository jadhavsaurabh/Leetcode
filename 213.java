/*
1,2,3,4,5
first try for 1,2,3,4
then try for 2,3,4,5

whichever max pick that up
*/
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        if(nums.length == 3) return Math.max(nums[0], Math.max(nums[1], nums[2]));

        int prev = nums[0];
        int next = Math.max(nums[0], nums[1]);

        for(int i=2;i<nums.length - 1;i++) {
            int cur = nums[i] + prev;
            prev = next;
            next = Math.max(cur, next);
        }
        int res1 = next;
        prev = nums[1];
        next = Math.max(nums[1], nums[2]);
        for(int i=3;i<nums.length;i++) {
            int cur = nums[i] + prev;
            prev = next;
            next = Math.max(cur, next);
        }
        int res2 = next;

        return Math.max(res2, res1);
    }
}
