class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        int prev2 = 0;
        int prev1 = 0;
        
        for(int house: nums) {
            int max = Math.max(prev2 + house, prev1);
            prev2 = prev1;
            prev1 = max;           
        }

        return prev1;
    }
}
