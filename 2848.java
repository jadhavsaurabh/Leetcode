class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        int[] diff = new int[102];

    
        for (List<Integer> car : nums) {
            diff[car.get(0)]++;
            diff[car.get(1) + 1]--;
        }

        int totalPoints = 0;
        int activeCars = 0;

        for (int i = 1; i <= 100; i++) {
            activeCars += diff[i];
            if (activeCars > 0) {
                totalPoints++;
            }
        }

        return totalPoints;
    }
}
