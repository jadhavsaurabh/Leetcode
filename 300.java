/*
Start from backword, store max length so far.
Time - O(n2)
*/
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] lens = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            lens[i] = 1;
        }
        
        for(int i=nums.length - 1;i>=0;i--) {
            
            for(int j=i+1;j< nums.length;j++) {
                if(nums[i] < nums[j]) {
                    lens[i] = Math.max(lens[i], 1 + lens[j]);
                }
            }
            
        }
        return Arrays.stream(lens).max().getAsInt();
    }
}
