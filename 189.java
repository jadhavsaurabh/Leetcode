/*
Brute force declare another array and copy paste
*/

class Solution {
    public void rotate(int[] nums, int k) {
        int[] res = new int[nums.length];

        k = k % nums.length;
        for(int i=0;i<nums.length;i++) {
            res[i] = nums[((i + (nums.length) - k)) % nums.length];
        }
        for(int i=0;i<nums.length;i++) {
            nums[i] = res[i];
        }
    }
}

/*
Using O(1)
*/
class Solution {
    public void reverse(int[] nums, int l, int r) {
        // Reverse from index l to r-1 (not including r)
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length; 

        if (k == 0) return;

        // Reverse the entire array
        reverse(nums, 0, nums.length - 1);

        // Reverse the first k elements
        reverse(nums, 0, k - 1);

        // Reverse the remaining elements
        reverse(nums, k, nums.length - 1);
    }
}
