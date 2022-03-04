class Solution {
    public int getAdder(int leng) {
        int res = 1;
        int addr = 2;
        int ind = 3;
        
        while(ind<leng) {
            res = res + addr;
            addr++;
            ind++;
        }
        
        return res; 
    }
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3) {
            return 0;
        }
        int res = 0;
        
        int i = 0;
        
        while(i <= nums.length-3) {
            if((nums[i] - nums[i+1]) == (nums[i+1] - nums[i+2])) {
                int leng = 3;
                int diff = (nums[i] - nums[i+1]);
                for(int j=i+leng;j<nums.length;j++) {
                    if((nums[j-1] - nums[j]) == diff) {
                        leng++;
                        continue;
                    } else {
                        break;
                    }
                }
                System.out.println(leng);
                if(leng == 3) {
                    res = res + 1;
                } else {
                    
                    res = res + getAdder(leng);
                }
                i=i+leng - 1;
            } else {
                i++;
            } 
        }
        return res;
    }
}
