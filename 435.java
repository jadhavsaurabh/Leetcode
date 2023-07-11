// sort by start point
// if first start >= next end then non overlapping update prevend
// else keep the end which is min to avoid number of collisions
// note: larger the interval, larger is the collision probability
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int res = 0;
        int prevEnd = intervals[0][1];
        for(var interval: intervals) {
            if(interval[0] >= prevEnd) {
                prevEnd = interval[1];
            } else {
                res++;
                prevEnd = Math.min(prevEnd, interval[1]);
            }
        }
        
        return res - 1;
    }
}
