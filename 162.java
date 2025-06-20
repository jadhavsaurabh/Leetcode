// Brute force
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        int res = -1;
        if(nums[0] > nums[1]) return 0;
        if(nums[nums.length - 1] > nums[nums.length - 2]) return nums.length - 1;

        for(int i=1;i<nums.length-1;i++) {
           if (nums[i - 1] < nums[i] && nums[i] > nums[i+1]) {
               res = i;
               break;
           }
        }

        return res;
    }
}

// Optimized
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
