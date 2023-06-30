class Solution {
    public int pivotIndex(int[] nums) {
        int rs = 0;
        int ls = 0;

        int res = -1;
        for(int i=1;i<nums.length;i++) {
            rs += nums[i];
        }

        for(int i=0;i<nums.length;i++) {
            if(ls == rs) {
                return i;
            }
            if(i + 1 < nums.length)
                rs -= nums[i+1];
            ls += nums[i];
        }
        return -1;
    }
}
