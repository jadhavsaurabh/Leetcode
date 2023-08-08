class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        
        List<int[]> mergedIntervals = new ArrayList<>();
        
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        for (int[] interval : intervals) {
            if (interval[0] <= end) {
                end = Math.max(interval[1], end);
            } else {
                mergedIntervals.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }
        
        mergedIntervals.add(new int[]{start, end});
        
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
