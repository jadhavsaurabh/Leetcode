class Solution {
    public void moveZeroes(int[] nums) {
        int zc=0;
        int[] res = new int[nums.length];
        int resc = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                zc++;
            } else {
                res[resc++] = nums[i];
            }
        }
        
        while(zc > 0) {
            res[resc++] = 0;
            zc--;
        }
        for(int i=0;i<nums.length;i++){
            nums[i] = res[i];
        }
        
    }
}
