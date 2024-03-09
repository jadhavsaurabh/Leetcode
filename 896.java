class Solution {
    public boolean isMonotonic(int[] nums) {
        if(nums.length <= 2) return true;
        boolean dec = nums[0] > nums[nums.length - 1];

        for(int i=1;i<nums.length;i++) {
            if((nums[i] > nums[i-1]) && dec) {
                return false;
            }
            if((nums[i] < nums[i-1]) && !dec) {
                return false;
            }
        }
        return true;
    }
}
