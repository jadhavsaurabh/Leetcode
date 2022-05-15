/*
For every stair decide between its previous or its prev prev to continue with
*/
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        if(len <=2) return Math.min(cost[0], cost[1]);
        cost[2] = cost[2] + Math.min(cost[0], cost[1]);
        
        for(int i=3;i<cost.length;i++) {
            cost[i] += Math.min(cost[i-2], cost[i-1]);
        }
        return Math.min(cost[len-1], cost[len-2]);
    }
}
