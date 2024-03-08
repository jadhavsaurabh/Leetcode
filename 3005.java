class Solution {
    public int maxFrequencyElements(int[] nums) {
        int res = 1;
        int[] counts = new int[100];

        for (int num : nums) {
            counts[num - 1]++;
        }

        int max = 0;
        
        for(int count: counts) {
            if(count > max) {
                max = count;
            }
        }

        int mxCount = 0;
        for(int count: counts) {
            if(count == max) {
                mxCount++;
            }
        }
        return mxCount * max;
    }
}
