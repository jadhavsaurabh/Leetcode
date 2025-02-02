class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        
        for(int i = 0;i< gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }

        if(totalCost > totalGas) return -1;

        int totalgc = 0;
        int result = 0;
        for(int i = 0;i<gas.length;i++) {

            totalgc += gas[i] - cost[i];
            if(totalgc < 0) {
                result = i + 1;
                totalgc = 0;
            }
        }

        return result;
    }
}
