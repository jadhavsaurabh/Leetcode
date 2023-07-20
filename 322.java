class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] amounts = new int[amount + 1];

        for(int i=0;i<amounts.length;i++) {
            amounts[i] = amount+1;
        }

        amounts[0] = 0;

        for(int i=1;i<=amount;i++) {
            for(int j=0;j<coins.length;j++) {
                if(i - coins[j] >= 0) {
                    amounts[i] = Math.min(amounts[i], 1 + amounts[i - coins[j]]);
                }
            }
        }

        if(amounts[amount] != amount + 1) {
            return amounts[amount];
        }
        return -1;
    }
}
