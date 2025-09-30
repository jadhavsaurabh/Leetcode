class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int curCap = capacity;
        int steps = 0;
        for(int i=0;i<plants.length;i++) {
            if (curCap - plants[i] < 0) {
                steps += (2 * i);
                curCap = capacity;
            }
            steps++;
            curCap -= plants[i];
        }

        return steps;
    }
}
