class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int inc = 1;
        int prevInc = 0;
        int res = 1;
        for(int i=1;i<nums.size();i++) {
            if(nums.get(i) > nums.get(i - 1)) {
                inc++;
            } else {
                res = Math.max(res, Math.max(inc / 2, Math.min(prevInc, inc)));
                prevInc = inc;
                inc = 1;
            }
        }
        res = Math.max(res, Math.max(inc / 2, Math.min(prevInc, inc)));
        return res;
    }
}
