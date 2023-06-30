class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int prev = 0;
        
        for(int i=0;i<gain.length;i++) {
            int curr = prev + gain[i];
            if(curr > max) {
                max = curr;
            }
            prev = curr;
        }
        return max;
    }
}
