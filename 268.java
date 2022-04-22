class Solution {
    public int missingNumber(int[] nums) {
        int tot = 0;
        int s = 0;
        for(int i=1;i<=nums.length;i++) {
            s += i;
        }
        for(int num: nums) {
            tot += num;
        }
        
        return s - tot;
    }
}
