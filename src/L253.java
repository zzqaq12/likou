import java.util.Arrays;

public class L253 {
    /**
     * 给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间 [[s1,e1],[s2,e2],…] (si < ei)，
     *  为避免会议冲突，同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。
     */
    public static void main(String[] args) {

        int[][] intervals = {{0,30},{5,10},{15,20}};
        System.out.println(minMeetingRooms(intervals));
    }
    public static int minMeetingRooms(int[][] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int startIndex = 0;
        int endIndex =0;
        int count = 0;
        while (startIndex < intervals.length){
            //开始时间小于结束的时间
            if (start[startIndex] < end[endIndex]){
                count++;
                startIndex++;
            }else {
                //开始时间大于结束的时间
                count--;
                endIndex++;
            }
        }
        return count;
    }
}
