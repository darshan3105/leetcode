import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/merge-intervals/
// TC: O(nlogn)
// SC: O(1) excluding the space required to store the result
// where n is the size of intervals

class SolutionA {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        int[] cur = new int[2];
        cur[0] = intervals[0][0];
        cur[1] = intervals[0][1];
        int i=1;
        
        while(i<intervals.length) {
            if(intervals[i][0] <= cur[1]) {
                cur[1] = Math.max(cur[1], intervals[i][1]);
            }
            else {
                result.add(cur);
                cur = new int[2];
                cur[0] = intervals[i][0];
                cur[1] = intervals[i][1];
            }
            i++;
        }
        
        result.add(cur);
        int[][] resultArr = new int[result.size()][2];
        
        for(i=0;i<result.size();i++) {
            resultArr[i] = result.get(i);
        }
        
        return resultArr;
    }
}