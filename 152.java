/*
Maintain the min & max all the time, since min can be converted into max if next number is negative.
If zero reset the min, max to 1, as 1 is neutral value
*/
class Solution {
    public int maxProduct(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        
        int cMin = 1;
        int cMax = 1;
        
        for(int i=0;i<nums.length;i++) {
            if(nums[i] == 0) {
                cMin = 1;
                cMax = 1;
                continue;
            }
            
            int temp = cMax;
            cMax = Arrays.stream(new int[] {cMax * nums[i], cMin * nums[i], nums[i] }).max().getAsInt();
            cMin = Arrays.stream(new int[] {temp * nums[i], cMin * nums[i], nums[i] }).min().getAsInt();
            
            max = Math.max(max , cMax);
        }
        
        return max;
    }
}
