class Solution {
    public int minCost(String colors, int[] neededTime) {
        char prev = colors.charAt(0);
        
        int sum = neededTime[0];
        int max = sum;
        int res = 0;

        for(int i=1;i<colors.length();i++) {
            if(colors.charAt(i) == prev) {
                sum += neededTime[i];
                max = Math.max(max, neededTime[i]);
            } else {
                res += (sum - max);
                sum = neededTime[i];
                max = sum;
                prev = colors.charAt(i);
            }
        }
        
        return res + (sum - max);
    }
}
