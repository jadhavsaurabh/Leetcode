class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for(int i=coins.length - 1;i >= 0;i--) {
            int[] nextDp = new int[amount + 1];
            nextDp[0] = 1;

            for(int curr=1;curr<=amount;curr++) {
                nextDp[curr] = dp[curr];

                if(curr - coins[i] >= 0) {
                    nextDp[curr] += nextDp[curr - coins[i]];
                }
            }

            dp = nextDp;
        }

        return dp[amount];
    }

}
