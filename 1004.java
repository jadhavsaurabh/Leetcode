/*
Sliding window if curr = 0 then decrease allowed zeroes.
if allowed zeroes exceed then move window parallely
if begin of window is zero then increase allowed zero as that zero is kicked out of the window
*/
class Solution {
    public int longestOnes(int[] nums, int k) {
        int numZero = 0;

        int l = 0;
        int r = 0;
        int len = nums.length;
        while(r<len) {
            if(nums[r] == 0) k--;
            if(k<0){
                if(nums[l] == 0) k++;
                l++;
            }
            r++;
        }
        return r - l;
    }
}
