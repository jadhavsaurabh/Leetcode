class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (nums[m] == target) return true;

            // If left half is sorted
            if (nums[l] < nums[m]) {
                if (nums[l] <= target && target < nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
            // If right half is sorted
            else if (nums[m] < nums[l]) {
                if (nums[m] < target && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            // nums[l] == nums[m], we can't be sure which part is sorted, so skip the duplicate
            else {
                l++;
            }
        }

        return false;
    }
}
