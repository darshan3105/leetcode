// https://leetcode.com/problems/merge-intervals/
// TC: O(nlogn)
// SC: O(1) excluding the space required to store the result
// where n is the size of intervals

class SolutionA {
    public int[][] merge(int[][] intervals) {
        int m = intervals.length;
        int[][] result = new int[m][2];
        int size = 0;
        
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
                result[size++] = cur;
                cur = new int[2];
                cur[0] = intervals[i][0];
                cur[1] = intervals[i][1];
            }
            i++;
        }
        
        result[size++] = cur;
        
        return result;
    }
}