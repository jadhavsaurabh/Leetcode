class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 3) {
            return nums.length;
        }
        
        var i=2;
        for(var j=i;j<nums.length;j++) {
            if(nums[i-2] != nums[j]){
                nums[i] = nums[j];
                i++;
            }                
        }
        return i;
    }
}
