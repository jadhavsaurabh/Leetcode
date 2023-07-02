/*
Maintain total length of 1's substring
eg 0,1,1,1,0,1
-> 0,3,2,3,0,1
*/
class Solution {
    public int longestSubarray(int[] nums) {
        int[] prefix = new int[nums.length];

        int i = 0;
        while(i<nums.length) {
            if(nums[i] == 1) {
                int idx = i;
                int count = 0;
                while(i < nums.length && nums[i] == 1) {
                    prefix[i++] = ++count;
                }
                prefix[idx] = count;
            } else {
                prefix[i++] = 0;
            }
        }

        int max = prefix[0];
        for(int j=0;j< prefix.length;j++) {
            if(j == 0 && prefix[j] == 0 && (j+1) < prefix.length) {
                int len = prefix[j+1] + 1;
                if(len > max) {
                    max = len;
                }
            } else if(j == prefix.length - 1 && prefix[j] == 0) {
                int len = prefix[j-1] + 1;
                if(len > max) {
                    max = len;
                }
            } else if(prefix[j] == 0) {
                int len = prefix[j - 1] + prefix[j+1] + 1;
                if(len > max) {
                    max = len;
                }
            }
        }
        return max-1;
    }
}
