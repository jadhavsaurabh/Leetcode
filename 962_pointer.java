class Solution {
    public int maxWidthRamp(int[] nums) {
        int[] max = new int[nums.length];

        int mx = nums[nums.length-1];
        for(int i=nums.length - 1;i>=0;i--) {
            if(nums[i] > mx) {
                mx = nums[i];
            }
            max[i] = mx;
        }

        int l = 0;
        int r = 1;

        int res = 0;
        while(l <= r && r < nums.length) {
            if(nums[l] <= max[r]) {
                r++;
                res = Math.max((r - l - 1), res);
            } else  {
                l++;
            }
        }
        
        return res;
    }
}
