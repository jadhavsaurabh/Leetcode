class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] diff = new int[101];

        for(int[] log: logs) {
            diff[log[0] - 1950]++;
            diff[log[1] - 1950]--;
        }

        //System.out.println(Arrays.toString(diff));
        int max = diff[0];
        int maxYear = 1950;
        for(int i=1;i<diff.length;i++) {
            diff[i] += diff[i - 1];
            if(diff[i] > max) {
                maxYear = 1950 + i;
                max = diff[i];
            }
        }

        return maxYear;
    }
}
