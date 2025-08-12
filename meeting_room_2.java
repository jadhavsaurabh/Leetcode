class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.isEmpty()) return 0;
        if(intervals.size() == 1) return 1;

        int[] starts = new int[intervals.size()];
        int[] ends = new int[intervals.size()];

        for(int i=0;i<intervals.size();i++) {
            Interval interval = intervals.get(i);
            starts[i] = interval.start;
            ends[i] = interval.end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int sptr = 0;
        int eptr = 0;
        int max = 0;
        int window = 0;

        while(sptr < starts.length && eptr < ends.length) {
            if(starts[sptr] < ends[eptr]) {
                window++;
                sptr++;
                max = Math.max(max, window);
            } else {
                eptr++;
                window--;
            }
        }
        
        return max;
    }
}
