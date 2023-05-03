class Solution {
    public int maxProfit(int[] prices) {
        int i = 0;
        int j = 1;

        int profit = 0;

        while(i < prices.length && j < prices.length) {
            if(prices[i] < prices[j]) {
                profit += prices[j] - prices[i];  
            }
            i++;
            j++;
        }
        return profit;
    }
}
