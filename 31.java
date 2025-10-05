import java.util.*;

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n == 1) return;

        int i = 1;
        int lastInc = -1;

        // Find the last increasing index
        while (i < n) {
            if (nums[i - 1] < nums[i])
                lastInc = i;
            i++;
        }

        // If no increasing pair found → array is descending
        if (lastInc == -1) {
            for (i = 0; i < n / 2; i++) {
                int temp = nums[i];
                nums[i] = nums[n - i - 1];
                nums[n - i - 1] = temp;
            }
            return;
        }

        int index = lastInc;

        // Find element just larger than nums[lastInc - 1]
        for (i = lastInc; i < n; i++) {
            if (nums[i] > nums[lastInc - 1] && nums[i] <= nums[index]) {
                index = i;
            }
        }

        // Swap nums[lastInc - 1] and nums[index]
        int temp = nums[lastInc - 1];
        nums[lastInc - 1] = nums[index];
        nums[index] = temp;

        // Reverse the remaining right part (instead of sorting)
        reverse(nums, lastInc, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
