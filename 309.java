class Solution {

    int dfs(int idx, Map<String, Integer> mp, int[] prices, boolean buying) {
        if(idx >= prices.length) return 0;
        if(mp.containsKey(idx + "_" + buying)) return mp.get(idx + "_" + buying);

        int coolDown = dfs(idx + 1, mp, prices, buying);
        if(buying) {
            int buy = dfs(idx + 1, mp, prices, false) - prices[idx];
            mp.put(idx + "_" + true, Math.max(buy, coolDown)); 
        } else {
            int sell = dfs(idx + 2, mp, prices, true) + prices[idx];
            mp.put(idx + "_" + false, Math.max(sell, coolDown));
        }
        
        return mp.get(idx + "_" + buying);
    }

    public int maxProfit(int[] prices) {
        Map<String, Integer> mp = new HashMap<>();

        return dfs(0, mp, prices, true);
    }
}
