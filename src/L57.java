import java.util.ArrayList;

public class L57 {

    /**
     * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表 intervals，其中 intervals[i] = [starti, endi] 表示第 i 个区间的开始和结束，并且 intervals 按照 starti 升序排列。
     * 同样给定一个区间 newInterval = [start, end] 表示另一个区间的开始和结束。
     *
     * 在 intervals 中插入区间 newInterval，使得 intervals 依然按照 starti 升序排列，且区间之间不重叠（如果有必要的话，可以合并区间）。
     */
    public static void main(String[] args)
    {
        int[][] intervals = {{1, 5}};
        int[] newInterval = {2, 3};
        int[][] result = insert(intervals, newInterval);
        for (int i = 0; i < result.length; i++)
        {
            System.out.println(result[i][0] + " " + result[i][1]);
        }
    }
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        boolean inserted = false;
        int[][] result = new int[intervals.length][2];
        for (int i = 0; i < intervals.length; i++) {
            result[i] = intervals[i];
        }
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            // 如果当前区间的结束小于newInterval的开始，则直接添加
            if (result[i][1] < newInterval[0]) {
                list.add(result[i]);
            } else if (result[i][0] > newInterval[1]) {
                // 如果当前区间的开始大于newInterval的结束，则将newInterval添加到结果中，并添加当前区间
                if (!inserted) {
                    list.add(newInterval);
                    inserted = true;
                }
                list.add(result[i]);
            } else {
                // 如果当前区间和newInterval有交集，则合并区间
                newInterval[0] = Math.min(newInterval[0], result[i][0]);
                newInterval[1] = Math.max(newInterval[1], result[i][1]);
            }

        }
        if (!inserted) {
            list.add(newInterval);
        }

        return list.toArray(new int[list.size()][2]);
    }
}
