import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class L56 {
    /**
     * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
     * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
     */
    public static void main(String[] args) {
        int[][] intervals = {{2,6},{1,3},{8,10},{15,18}};
        int[][] res = merge(intervals);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i][0] + " " + res[i][1]);
        }

    }
    public static int[][] merge(int[][] intervals) {

        int[][] res = new int[intervals.length][2];
        for (int i = 0; i < intervals.length; i++) {
            int[] temp = intervals[i];
            res[i][0] = temp[0];
            res[i][1] = temp[1];
        }
        //使用Comparator按左端点排序
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0]) {
                    return 1;
                } else if (o1[0] < o2[0]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };
        Arrays.sort(res,comparator);
        //合并
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < res.length; i++) {
            if (list.size() == 0) {
                list.add(res[i]);
            } else {
                int[] temp = list.get(list.size() - 1);
                if (temp[1] >= res[i][0]) {
                    temp[1] = Math.max(temp[1], res[i][1]);
                } else {
                    list.add(res[i]);
                }
            }
        }
        return list.toArray(new int[list.size()][2]);



    }

}
