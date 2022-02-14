class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        int res = nums[0] + nums[1] + nums[nums.length - 1];
    
        for(int i=0; i<nums.length-2;i++) {
            int start = i+1;
            int end = nums.length - 1;
            int diff = 10000000;
            
            while(start < end) {
                int currsum = nums[i] + nums[start] + nums[end];
                if(currsum == target) {
                    return target;
                } else if(currsum < target) {
                    start++;
                } else {
                    end--;
                }
                
                if(Math.abs(currsum - target) < Math.abs(res - target)) {
                    res = currsum;
                }
            }
        }
        return res;
    }
}
