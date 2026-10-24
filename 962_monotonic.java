class Solution {
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> stk = new Stack<>();
        stk.push(0);
        for(int i=1;i<nums.length;i++) {
            if(nums[stk.peek()] > nums[i]) {
                stk.push(i);
            }
        }

        int max = 0;
        for(int i=nums.length - 1;i>=0;) {
            if(stk.isEmpty()) break;
            if(nums[i] >= nums[stk.peek()]) {
                max = Math.max(i - stk.pop(), max);
            } else {
                i--;
            }
        }

        return max;
    }
}
