class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int len = costs.length;
        int[] profits = new int[len];
    
        int minCost = 0, index = 0;
        for(int i=0;i<len;i++){
            profits[index++] = costs[i][1] - costs[i][0];
            minCost += costs[i][0];
        }
        Arrays.sort(profits);
        for(int i = 0; i < len / 2; i++){
            minCost += profits[i];
        }
        return minCost;
    }
}
