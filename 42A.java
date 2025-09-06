class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int[] maxLeft = new int[len];
        int[] maxRight = new int[len];

        int max = 0;
        for(int i=0;i<len;i++) {
            maxLeft[i] = max;
            if(max < height[i]) max = height[i];
        }
        max = 0;
        for(int i=len - 1;i>=0;i--) {
            maxRight[i] = max;
            if(max < height[i]) max = height[i];
        }

        int[] minHeight = new int[len];
        for(int i=0;i<len;i++) {
            minHeight[i] = Math.min(maxLeft[i], maxRight[i]);
        }

        int res = 0;
        for(int i=0;i<len;i++) {
            int water = minHeight[i] - height[i];
            if(water > 0) {
                res += water;
            }
        }
        
        return res;
    }
}
