class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));

        int prevEnd = points[0][1];
        int arrows = 0;

        for(int i = 1;i< points.length; i++) {
            // if non overlapping then increment arrows
            if(points[i][0] > prevEnd) {
                prevEnd = points[i][1];
                arrows++;
            } else {
                // choose min, if we choose max then finding smaller overlapping ballons will be difficult
                prevEnd = Math.min(prevEnd, points[i][1]);
            }
        }

        // need to shootdown 1st baloon
        return arrows + 1;
    }
}
