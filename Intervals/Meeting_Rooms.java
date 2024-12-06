public class Interval {
    public int start, end;
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Solution {
    private boolean canAttendMeetingsBruteForceApproach(List<Interval> intervals) {
        for(int i = 0; i < intervals.size() - 1; i++){
            Interval interval1 = intervals.get(i);
            for(int j = i + 1; j < intervals.size(); j++) {
                Interval interval2 = intervals.get(j);
                if(Math.max(interval1.start, interval2.start) 
                    < Math.min(interval1.end, interval2.end)) {
                        return false;
                    }
            }
        }
        return true;
    }

    private boolean canAttendMeetingsOptimizedApproachUsingSorting(List<Interval> intervals) {
        Collections.sort(intervals, Comparator.comparingInt(i -> i.start));

        for(int i = 1; i < intervals.size(); i++){
            if(intervals.get(i).start < intervals.get(i-1).end) return false;
        }
        return true;
    }

    public boolean canAttendMeetings(List<Interval> intervals) {
        return canAttendMeetingsOptimizedApproachUsingSorting(intervals);
    }
}

