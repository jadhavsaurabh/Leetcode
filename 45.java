class Solution {
    public int jump(int[] nums) {

        if(nums.length == 1) return 0;
        int l = 1, r = nums[0];
        int res = 1;
        
        while (r < nums.length - 1) {
            int farthest = 0;
            
            for(int i=l;i<=r;i++) {
                farthest = Math.max(farthest, nums[i] + i);
            }
            l = r + 1;
            r = farthest;
            res++;
        }
        return res;
    }
}
