// Solution O(n) space
class Solution {
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int[] count = new int[len - 1];
        
        int res = -1;
        for(int i=0;i<len;i++) {
            if(count[nums[i] - 1] == 0) {
                count[nums[i] - 1] = 1;
            } else {
                res = nums[i];
                break;
            }
        }
        System.out.println(res);
        return res;
    }
}
