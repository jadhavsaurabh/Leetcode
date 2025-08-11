/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.isEmpty()) return true;
        if(intervals.size() == 1) return true;
        intervals.sort(Comparator.comparingInt(a -> a.start));
        
        int prev = intervals.get(0).end;
        for(int i=1;i<intervals.size();i++) {
            Interval interval = intervals.get(i);
            if(prev > interval.start) return false;
            prev = interval.end;
        }
        
        return true;
    }
}
