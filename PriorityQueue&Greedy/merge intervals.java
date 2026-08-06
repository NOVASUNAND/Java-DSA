import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1) return intervals;
        
        // Fixed: Comparator capital C
        Arrays.sort(intervals, Comparator.comparingInt(i->i[0]));
        
        // Fixed: List type should be int[] instead of Integer
        List<int[]> result = new ArrayList<>();
        
        int[] newinterval = intervals[0];
        result.add(newinterval);
        
        // Fixed: Loop variable type is int[]
        for(int[] interval : intervals){
            // Fixed: Check if next start <= current end
            if(interval[0] <= newinterval[1]){
                newinterval[1] = Math.max(newinterval[1], interval[1]);
            } else {
                newinterval = interval;
                // Fixed: Syntax error semicolon inside parentheses
                result.add(newinterval);
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }
}
