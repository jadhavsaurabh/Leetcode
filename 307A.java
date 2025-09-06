class NumArray {
    int[] preFix;
    public NumArray(int[] nums) {
        preFix = new int[nums.length];
        preFix[0] = nums[0];
        for(int i=1;i<nums.length;i++) {
            preFix[i] += preFix[i-1] + nums[i];
        }
    }

    public void update(int index, int val) {
        int curr = index == 0 ? preFix[0] : preFix[index] - preFix[index - 1];
        
        int gap = curr - val;
        for(int i=index;i< preFix.length;i++) {
            preFix[i] -= gap;
        }
    }

    public int sumRange(int left, int right) {
        if(left == 0) return preFix[right];

        return preFix[right] - preFix[left - 1];
    }
}
